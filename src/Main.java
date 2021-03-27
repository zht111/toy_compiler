import AST.RootNode;
import Backend.*;
import Frontend.*;
import MIR.*;
import Assembly.*;
import Parser.MxLexer;
import Parser.MxParser;
import Util.MxErrorListener;
import Util.error.error;
import Util.globalScope;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class Main {
	public static void main(String[] args) throws Exception{
		boolean SemanticOnly = false, emitLLVM = false;
		int optLevel = 0;	
		if(args.length > 0) {
			for (String arg : args) {
				switch (arg) {
					case "-semantic": SemanticOnly = true;break;
					case "-ll": emitLLVM = true;break;
					default: break;
				}
			}
		}	
		String name = "test.mx";
		//InputStream input = new FileInputStream(name);
		//PrintStream output = new PrintStream("output.s");
		InputStream input = System.in;
		PrintStream output = System.out;
		try {
			RootNode ASTRoot;
			globalScope gScope = new globalScope(null);
			MxLexer lexer = new MxLexer(CharStreams.fromStream(input));
			lexer.removeErrorListeners();
			lexer.addErrorListener(new MxErrorListener());
			MxParser parser = new MxParser(new CommonTokenStream(lexer));
			parser.removeErrorListeners();
			parser.addErrorListener(new MxErrorListener());
			ParseTree parseTreeRoot = parser.program();
			ASTBuilder astBuilder = new ASTBuilder(gScope);
			ASTRoot = (RootNode)astBuilder.visit(parseTreeRoot);
			Root f = new Root();
			new SymbolCollector(gScope, f).visit(ASTRoot);			
			new TypeFilter(gScope).visit(ASTRoot);			
			new SemanticChecker(gScope, f).visit(ASTRoot);
			if(SemanticOnly) return;		
			new IRBuilder(gScope, f).visit(ASTRoot);
			if(emitLLVM) new IRPrinter(System.out, true).run(f);	
			LRoot lRoot = new InstSelector(f).run();		
			new RegAlloc(lRoot).run();		
			new AsmPrinter(lRoot, output, true).run();	
		} catch (error er) {
			System.err.println(er.toString());
			throw new RuntimeException();
		}
	}
}