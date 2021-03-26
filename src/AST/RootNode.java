package AST;

import Util.position;

import java.util.ArrayList;

public class RootNode extends ASTNode {

    private ArrayList<ASTNode> allDef;
    public RootNode(ArrayList<ASTNode> allDef, position pos) {
        super(pos);
        this.allDef = allDef;
    }

    public ArrayList<ASTNode> allDef(){
        return allDef;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
