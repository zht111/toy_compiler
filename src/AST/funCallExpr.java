package AST;

import Util.position;

import java.util.ArrayList;

public class funCallExpr extends exprNode {

    private ArrayList<exprNode> params;
    private exprNode callee;

    public funCallExpr(exprNode callee, exprList params, position pos) {
        super(pos, false);
        this.callee = callee;
        this.params = params == null ? new ArrayList<>() : params.params();
    }

    public exprNode callee() {
        return callee;
    }
    public void resetCallee(exprNode callee) {
        this.callee = callee;
    }

    public ArrayList<exprNode> params() {
        return params;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
