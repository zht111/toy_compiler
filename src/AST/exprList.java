package AST;

import Util.position;

import java.util.ArrayList;

public class exprList extends ASTNode {
    private ArrayList<exprNode> params = new ArrayList<>();

    public exprList(position pos) {
        super(pos);
    }

    public void addParam(exprNode param) {
        params.add(param);
    }

    public ArrayList<exprNode> params() {
        return params;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
