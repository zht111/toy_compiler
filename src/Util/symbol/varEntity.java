package Util.symbol;

import MIR.IRoperand.ConstInt;
import MIR.IRoperand.Operand;

public class varEntity extends Entity {

    private Type type;
    private boolean isGlobal, isMember;
    private Operand asOperand;
    private ConstInt index;

    public varEntity(String name, Type type, boolean isGlobal) {
        super(name);
        this.type = type;
        this.isGlobal = isGlobal;
        this.isMember = false;
    }

    public ConstInt elementIndex() {
        return index;
    }
    public void setElementIndex(int index) {
        this.index = new ConstInt(index, 32);
    }
    public Type type() { return type; }
    public boolean isGlobal() { return isGlobal; }
    public void setIsMember() {
        isMember = true;
    }
    public boolean isMember() {
        return isMember;
    }
    public void setOperand(Operand ope) {
        asOperand = ope;
    }
    public Operand asOperand() {
        return asOperand;
    }
}
