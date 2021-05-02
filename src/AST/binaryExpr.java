package AST;

import Util.position;

public class binaryExpr extends exprNode{
    public enum opCategory {
        Star, Div, Mod, LeftShift, RightShift, And, Or, Caret, Minus, Plus,
        Less, Greater, LessEqual, GreaterEqual, AndAnd, OrOr,
        Equal, NotEqual
    }
//     *, /, %, <<, >>, &, |, ^, -, +,  <,  >, <=, >=, &&, ||, ==, !=
//     0, 1, 2,  3,  4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17
    private exprNode src1, src2;
    private opCategory opCode;

    public binaryExpr(exprNode src1, exprNode src2, opCategory opCode, position pos) {
        super(pos, false);
        this.src1 = src1;
        this.src2 = src2;
        this.opCode = opCode;
    }

    public exprNode src1() {
        return src1;
    }

    public exprNode src2() {
        return src2;
    }

    public opCategory opCode() {
        return opCode;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
