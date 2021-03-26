package Assembly.RISCInst;

import Assembly.LIRBlock;
import Assembly.LOperand.GReg;
import Assembly.LOperand.Reg;

import java.util.Collections;
import java.util.HashSet;

public class La extends RISCInst{

    private GReg origin;

    public La(GReg origin, Reg dest, LIRBlock block) {
        super(dest, block);
        this.origin = origin;
    }

    @Override
    public HashSet<Reg> uses() {
        return new HashSet<>();
    }
    @Override
    public HashSet<Reg> defs() {
        return new HashSet<>(Collections.singletonList(dest()));
    }
    @Override
    public void replaceUse(Reg origin, Reg replaced) {}

    @Override
    public void stackLengthAdd(int stackLength) {}

    @Override
    public String toString() {
        return "la " + dest() + ", " + origin;
    }
}
