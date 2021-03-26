package MIR.IRoperand;


import MIR.IRinst.Inst;
import MIR.IRtype.IRBaseType;

import java.util.HashSet;

public class Param extends Operand {

    private String name;
    private HashSet<Inst> uses = new HashSet<>();

    public Param(IRBaseType type, String name) {
        super(type);
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String name() {
        return name;
    }

    @Override
    public void addUse(Inst inst) {
        uses.add(inst);
    }
    @Override
    public void removeUse(Inst inst) {
        uses.remove(inst);
    }
    @Override
    public HashSet<Inst> uses() {
        return uses;
    }
    @Override
    public Operand copy() {
        return new Param(type(), name);
    }

    @Override
    public String toString() {
        return "%" + name;
    }
}
