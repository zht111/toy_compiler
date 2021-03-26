package AST;

import Util.position;

public class exprStmt extends stmtNode {

    private exprNode expr;

    public exprStmt(exprNode expr, position pos) {
        super(pos);
        this.expr = expr;
    }

    public exprNode expr() {
        return expr;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
