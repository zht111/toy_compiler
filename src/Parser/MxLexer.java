// Generated from C:\Users\lenovo\Desktop\mxcompiler\compiler\temp\toy_compiler\src\Parser\Mx.g4 by ANTLR 4.9.1
package Parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MxLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Bool=1, Int=2, Void=3, String=4, Null=5, If=6, Else=7, Continue=8, Break=9, 
		For=10, Return=11, Switch=12, While=13, This=14, True=15, False=16, New=17, 
		Class=18, LeftParen=19, RightParen=20, LeftBracket=21, RightBracket=22, 
		LeftBrace=23, RightBrace=24, Less=25, LessEqual=26, Greater=27, GreaterEqual=28, 
		LeftShift=29, RightShift=30, Plus=31, PlusPlus=32, Minus=33, MinusMinus=34, 
		Star=35, Div=36, Mod=37, And=38, Or=39, AndAnd=40, OrOr=41, Caret=42, 
		Not=43, Tilde=44, Question=45, Colon=46, Semi=47, Comma=48, Assign=49, 
		Equal=50, NotEqual=51, Dot=52, StringLiteral=53, Identifier=54, DecimalInteger=55, 
		Whitespace=56, Newline=57, BlockComment=58, LineComment=59;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"Bool", "Int", "Void", "String", "Null", "If", "Else", "Continue", "Break", 
			"For", "Return", "Switch", "While", "This", "True", "False", "New", "Class", 
			"LeftParen", "RightParen", "LeftBracket", "RightBracket", "LeftBrace", 
			"RightBrace", "Less", "LessEqual", "Greater", "GreaterEqual", "LeftShift", 
			"RightShift", "Plus", "PlusPlus", "Minus", "MinusMinus", "Star", "Div", 
			"Mod", "And", "Or", "AndAnd", "OrOr", "Caret", "Not", "Tilde", "Question", 
			"Colon", "Semi", "Comma", "Assign", "Equal", "NotEqual", "Dot", "StringLiteral", 
			"SChar", "Identifier", "DecimalInteger", "Whitespace", "Newline", "BlockComment", 
			"LineComment"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'bool'", "'int'", "'void'", "'string'", "'null'", "'if'", "'else'", 
			"'continue'", "'break'", "'for'", "'return'", "'switch'", "'while'", 
			"'this'", "'true'", "'false'", "'new'", "'class'", "'('", "')'", "'['", 
			"']'", "'{'", "'}'", "'<'", "'<='", "'>'", "'>='", "'<<'", "'>>'", "'+'", 
			"'++'", "'-'", "'--'", "'*'", "'/'", "'%'", "'&'", "'|'", "'&&'", "'||'", 
			"'^'", "'!'", "'~'", "'?'", "':'", "';'", "','", "'='", "'=='", "'!='", 
			"'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Bool", "Int", "Void", "String", "Null", "If", "Else", "Continue", 
			"Break", "For", "Return", "Switch", "While", "This", "True", "False", 
			"New", "Class", "LeftParen", "RightParen", "LeftBracket", "RightBracket", 
			"LeftBrace", "RightBrace", "Less", "LessEqual", "Greater", "GreaterEqual", 
			"LeftShift", "RightShift", "Plus", "PlusPlus", "Minus", "MinusMinus", 
			"Star", "Div", "Mod", "And", "Or", "AndAnd", "OrOr", "Caret", "Not", 
			"Tilde", "Question", "Colon", "Semi", "Comma", "Assign", "Equal", "NotEqual", 
			"Dot", "StringLiteral", "Identifier", "DecimalInteger", "Whitespace", 
			"Newline", "BlockComment", "LineComment"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public MxLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Mx.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2=\u0178\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31"+
		"\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\37"+
		"\3\37\3\37\3 \3 \3!\3!\3!\3\"\3\"\3#\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3"+
		"(\3(\3)\3)\3)\3*\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3"+
		"\61\3\62\3\62\3\63\3\63\3\63\3\64\3\64\3\64\3\65\3\65\3\66\3\66\7\66\u012f"+
		"\n\66\f\66\16\66\u0132\13\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\3\67\3"+
		"\67\5\67\u013d\n\67\38\38\78\u0141\n8\f8\168\u0144\138\39\39\79\u0148"+
		"\n9\f9\169\u014b\139\39\59\u014e\n9\3:\6:\u0151\n:\r:\16:\u0152\3:\3:"+
		"\3;\3;\5;\u0159\n;\3;\5;\u015c\n;\3;\3;\3<\3<\3<\3<\7<\u0164\n<\f<\16"+
		"<\u0167\13<\3<\3<\3<\3<\3<\3=\3=\3=\3=\7=\u0172\n=\f=\16=\u0175\13=\3"+
		"=\3=\3\u0165\2>\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65"+
		"\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64"+
		"g\65i\66k\67m\2o8q9s:u;w<y=\3\2\t\6\2\f\f\17\17$$^^\4\2C\\c|\6\2\62;C"+
		"\\aac|\3\2\63;\3\2\62;\4\2\13\13\"\"\4\2\f\f\17\17\2\u0182\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2"+
		"\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2"+
		"\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2"+
		"\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W"+
		"\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2"+
		"\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2"+
		"\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\3{\3\2\2\2\5\u0080\3\2\2"+
		"\2\7\u0084\3\2\2\2\t\u0089\3\2\2\2\13\u0090\3\2\2\2\r\u0095\3\2\2\2\17"+
		"\u0098\3\2\2\2\21\u009d\3\2\2\2\23\u00a6\3\2\2\2\25\u00ac\3\2\2\2\27\u00b0"+
		"\3\2\2\2\31\u00b7\3\2\2\2\33\u00be\3\2\2\2\35\u00c4\3\2\2\2\37\u00c9\3"+
		"\2\2\2!\u00ce\3\2\2\2#\u00d4\3\2\2\2%\u00d8\3\2\2\2\'\u00de\3\2\2\2)\u00e0"+
		"\3\2\2\2+\u00e2\3\2\2\2-\u00e4\3\2\2\2/\u00e6\3\2\2\2\61\u00e8\3\2\2\2"+
		"\63\u00ea\3\2\2\2\65\u00ec\3\2\2\2\67\u00ef\3\2\2\29\u00f1\3\2\2\2;\u00f4"+
		"\3\2\2\2=\u00f7\3\2\2\2?\u00fa\3\2\2\2A\u00fc\3\2\2\2C\u00ff\3\2\2\2E"+
		"\u0101\3\2\2\2G\u0104\3\2\2\2I\u0106\3\2\2\2K\u0108\3\2\2\2M\u010a\3\2"+
		"\2\2O\u010c\3\2\2\2Q\u010e\3\2\2\2S\u0111\3\2\2\2U\u0114\3\2\2\2W\u0116"+
		"\3\2\2\2Y\u0118\3\2\2\2[\u011a\3\2\2\2]\u011c\3\2\2\2_\u011e\3\2\2\2a"+
		"\u0120\3\2\2\2c\u0122\3\2\2\2e\u0124\3\2\2\2g\u0127\3\2\2\2i\u012a\3\2"+
		"\2\2k\u012c\3\2\2\2m\u013c\3\2\2\2o\u013e\3\2\2\2q\u014d\3\2\2\2s\u0150"+
		"\3\2\2\2u\u015b\3\2\2\2w\u015f\3\2\2\2y\u016d\3\2\2\2{|\7d\2\2|}\7q\2"+
		"\2}~\7q\2\2~\177\7n\2\2\177\4\3\2\2\2\u0080\u0081\7k\2\2\u0081\u0082\7"+
		"p\2\2\u0082\u0083\7v\2\2\u0083\6\3\2\2\2\u0084\u0085\7x\2\2\u0085\u0086"+
		"\7q\2\2\u0086\u0087\7k\2\2\u0087\u0088\7f\2\2\u0088\b\3\2\2\2\u0089\u008a"+
		"\7u\2\2\u008a\u008b\7v\2\2\u008b\u008c\7t\2\2\u008c\u008d\7k\2\2\u008d"+
		"\u008e\7p\2\2\u008e\u008f\7i\2\2\u008f\n\3\2\2\2\u0090\u0091\7p\2\2\u0091"+
		"\u0092\7w\2\2\u0092\u0093\7n\2\2\u0093\u0094\7n\2\2\u0094\f\3\2\2\2\u0095"+
		"\u0096\7k\2\2\u0096\u0097\7h\2\2\u0097\16\3\2\2\2\u0098\u0099\7g\2\2\u0099"+
		"\u009a\7n\2\2\u009a\u009b\7u\2\2\u009b\u009c\7g\2\2\u009c\20\3\2\2\2\u009d"+
		"\u009e\7e\2\2\u009e\u009f\7q\2\2\u009f\u00a0\7p\2\2\u00a0\u00a1\7v\2\2"+
		"\u00a1\u00a2\7k\2\2\u00a2\u00a3\7p\2\2\u00a3\u00a4\7w\2\2\u00a4\u00a5"+
		"\7g\2\2\u00a5\22\3\2\2\2\u00a6\u00a7\7d\2\2\u00a7\u00a8\7t\2\2\u00a8\u00a9"+
		"\7g\2\2\u00a9\u00aa\7c\2\2\u00aa\u00ab\7m\2\2\u00ab\24\3\2\2\2\u00ac\u00ad"+
		"\7h\2\2\u00ad\u00ae\7q\2\2\u00ae\u00af\7t\2\2\u00af\26\3\2\2\2\u00b0\u00b1"+
		"\7t\2\2\u00b1\u00b2\7g\2\2\u00b2\u00b3\7v\2\2\u00b3\u00b4\7w\2\2\u00b4"+
		"\u00b5\7t\2\2\u00b5\u00b6\7p\2\2\u00b6\30\3\2\2\2\u00b7\u00b8\7u\2\2\u00b8"+
		"\u00b9\7y\2\2\u00b9\u00ba\7k\2\2\u00ba\u00bb\7v\2\2\u00bb\u00bc\7e\2\2"+
		"\u00bc\u00bd\7j\2\2\u00bd\32\3\2\2\2\u00be\u00bf\7y\2\2\u00bf\u00c0\7"+
		"j\2\2\u00c0\u00c1\7k\2\2\u00c1\u00c2\7n\2\2\u00c2\u00c3\7g\2\2\u00c3\34"+
		"\3\2\2\2\u00c4\u00c5\7v\2\2\u00c5\u00c6\7j\2\2\u00c6\u00c7\7k\2\2\u00c7"+
		"\u00c8\7u\2\2\u00c8\36\3\2\2\2\u00c9\u00ca\7v\2\2\u00ca\u00cb\7t\2\2\u00cb"+
		"\u00cc\7w\2\2\u00cc\u00cd\7g\2\2\u00cd \3\2\2\2\u00ce\u00cf\7h\2\2\u00cf"+
		"\u00d0\7c\2\2\u00d0\u00d1\7n\2\2\u00d1\u00d2\7u\2\2\u00d2\u00d3\7g\2\2"+
		"\u00d3\"\3\2\2\2\u00d4\u00d5\7p\2\2\u00d5\u00d6\7g\2\2\u00d6\u00d7\7y"+
		"\2\2\u00d7$\3\2\2\2\u00d8\u00d9\7e\2\2\u00d9\u00da\7n\2\2\u00da\u00db"+
		"\7c\2\2\u00db\u00dc\7u\2\2\u00dc\u00dd\7u\2\2\u00dd&\3\2\2\2\u00de\u00df"+
		"\7*\2\2\u00df(\3\2\2\2\u00e0\u00e1\7+\2\2\u00e1*\3\2\2\2\u00e2\u00e3\7"+
		"]\2\2\u00e3,\3\2\2\2\u00e4\u00e5\7_\2\2\u00e5.\3\2\2\2\u00e6\u00e7\7}"+
		"\2\2\u00e7\60\3\2\2\2\u00e8\u00e9\7\177\2\2\u00e9\62\3\2\2\2\u00ea\u00eb"+
		"\7>\2\2\u00eb\64\3\2\2\2\u00ec\u00ed\7>\2\2\u00ed\u00ee\7?\2\2\u00ee\66"+
		"\3\2\2\2\u00ef\u00f0\7@\2\2\u00f08\3\2\2\2\u00f1\u00f2\7@\2\2\u00f2\u00f3"+
		"\7?\2\2\u00f3:\3\2\2\2\u00f4\u00f5\7>\2\2\u00f5\u00f6\7>\2\2\u00f6<\3"+
		"\2\2\2\u00f7\u00f8\7@\2\2\u00f8\u00f9\7@\2\2\u00f9>\3\2\2\2\u00fa\u00fb"+
		"\7-\2\2\u00fb@\3\2\2\2\u00fc\u00fd\7-\2\2\u00fd\u00fe\7-\2\2\u00feB\3"+
		"\2\2\2\u00ff\u0100\7/\2\2\u0100D\3\2\2\2\u0101\u0102\7/\2\2\u0102\u0103"+
		"\7/\2\2\u0103F\3\2\2\2\u0104\u0105\7,\2\2\u0105H\3\2\2\2\u0106\u0107\7"+
		"\61\2\2\u0107J\3\2\2\2\u0108\u0109\7\'\2\2\u0109L\3\2\2\2\u010a\u010b"+
		"\7(\2\2\u010bN\3\2\2\2\u010c\u010d\7~\2\2\u010dP\3\2\2\2\u010e\u010f\7"+
		"(\2\2\u010f\u0110\7(\2\2\u0110R\3\2\2\2\u0111\u0112\7~\2\2\u0112\u0113"+
		"\7~\2\2\u0113T\3\2\2\2\u0114\u0115\7`\2\2\u0115V\3\2\2\2\u0116\u0117\7"+
		"#\2\2\u0117X\3\2\2\2\u0118\u0119\7\u0080\2\2\u0119Z\3\2\2\2\u011a\u011b"+
		"\7A\2\2\u011b\\\3\2\2\2\u011c\u011d\7<\2\2\u011d^\3\2\2\2\u011e\u011f"+
		"\7=\2\2\u011f`\3\2\2\2\u0120\u0121\7.\2\2\u0121b\3\2\2\2\u0122\u0123\7"+
		"?\2\2\u0123d\3\2\2\2\u0124\u0125\7?\2\2\u0125\u0126\7?\2\2\u0126f\3\2"+
		"\2\2\u0127\u0128\7#\2\2\u0128\u0129\7?\2\2\u0129h\3\2\2\2\u012a\u012b"+
		"\7\60\2\2\u012bj\3\2\2\2\u012c\u0130\7$\2\2\u012d\u012f\5m\67\2\u012e"+
		"\u012d\3\2\2\2\u012f\u0132\3\2\2\2\u0130\u012e\3\2\2\2\u0130\u0131\3\2"+
		"\2\2\u0131\u0133\3\2\2\2\u0132\u0130\3\2\2\2\u0133\u0134\7$\2\2\u0134"+
		"l\3\2\2\2\u0135\u013d\n\2\2\2\u0136\u0137\7^\2\2\u0137\u013d\7p\2\2\u0138"+
		"\u0139\7^\2\2\u0139\u013d\7^\2\2\u013a\u013b\7^\2\2\u013b\u013d\7$\2\2"+
		"\u013c\u0135\3\2\2\2\u013c\u0136\3\2\2\2\u013c\u0138\3\2\2\2\u013c\u013a"+
		"\3\2\2\2\u013dn\3\2\2\2\u013e\u0142\t\3\2\2\u013f\u0141\t\4\2\2\u0140"+
		"\u013f\3\2\2\2\u0141\u0144\3\2\2\2\u0142\u0140\3\2\2\2\u0142\u0143\3\2"+
		"\2\2\u0143p\3\2\2\2\u0144\u0142\3\2\2\2\u0145\u0149\t\5\2\2\u0146\u0148"+
		"\t\6\2\2\u0147\u0146\3\2\2\2\u0148\u014b\3\2\2\2\u0149\u0147\3\2\2\2\u0149"+
		"\u014a\3\2\2\2\u014a\u014e\3\2\2\2\u014b\u0149\3\2\2\2\u014c\u014e\7\62"+
		"\2\2\u014d\u0145\3\2\2\2\u014d\u014c\3\2\2\2\u014er\3\2\2\2\u014f\u0151"+
		"\t\7\2\2\u0150\u014f\3\2\2\2\u0151\u0152\3\2\2\2\u0152\u0150\3\2\2\2\u0152"+
		"\u0153\3\2\2\2\u0153\u0154\3\2\2\2\u0154\u0155\b:\2\2\u0155t\3\2\2\2\u0156"+
		"\u0158\7\17\2\2\u0157\u0159\7\f\2\2\u0158\u0157\3\2\2\2\u0158\u0159\3"+
		"\2\2\2\u0159\u015c\3\2\2\2\u015a\u015c\7\f\2\2\u015b\u0156\3\2\2\2\u015b"+
		"\u015a\3\2\2\2\u015c\u015d\3\2\2\2\u015d\u015e\b;\2\2\u015ev\3\2\2\2\u015f"+
		"\u0160\7\61\2\2\u0160\u0161\7,\2\2\u0161\u0165\3\2\2\2\u0162\u0164\13"+
		"\2\2\2\u0163\u0162\3\2\2\2\u0164\u0167\3\2\2\2\u0165\u0166\3\2\2\2\u0165"+
		"\u0163\3\2\2\2\u0166\u0168\3\2\2\2\u0167\u0165\3\2\2\2\u0168\u0169\7,"+
		"\2\2\u0169\u016a\7\61\2\2\u016a\u016b\3\2\2\2\u016b\u016c\b<\2\2\u016c"+
		"x\3\2\2\2\u016d\u016e\7\61\2\2\u016e\u016f\7\61\2\2\u016f\u0173\3\2\2"+
		"\2\u0170\u0172\n\b\2\2\u0171\u0170\3\2\2\2\u0172\u0175\3\2\2\2\u0173\u0171"+
		"\3\2\2\2\u0173\u0174\3\2\2\2\u0174\u0176\3\2\2\2\u0175\u0173\3\2\2\2\u0176"+
		"\u0177\b=\2\2\u0177z\3\2\2\2\r\2\u0130\u013c\u0142\u0149\u014d\u0152\u0158"+
		"\u015b\u0165\u0173\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}