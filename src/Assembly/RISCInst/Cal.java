package Assembly.RISCInst;

import Assembly.LFn;
import Assembly.LIRBlock;
import Assembly.LOperand.Reg;
import Assembly.LRoot;

import java.util.HashSet;

public class Cal extends RISCInst{
    private LFn callee;
    private LRoot root;

    public Cal(LRoot root, LFn callee, LIRBlock block) {
        super(null, block);
        this.callee = callee;
        this.root = root;
    }

    public LFn callee() {
        return callee;
    }

    @Override
    public HashSet<Reg> uses() {
        HashSet<Reg> ret = new HashSet<>();
        for (int i = 0;i < Integer.min(callee.params().size(), 8);++i)
            ret.add(root.getPhyReg(10 + i));
        return ret;
    }
    @Override
    public HashSet<Reg> defs() {
        return new HashSet<>(root.callerSave());
    }

    @Override
    public void replaceUse(Reg origin, Reg replaced) {}

    @Override
    public void stackLengthAdd(int stackLength) {}

    @Override
    public String toString() {
        return "call " + callee.name();
    }
}
