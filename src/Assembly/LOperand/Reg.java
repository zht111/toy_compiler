package Assembly.LOperand;

import Assembly.RISCInst.Mv;

import java.util.HashSet;

public abstract class Reg extends LOperand {
    public int degree = 0;
    public double weight = 0;
    public Reg alias = null;
    public PhyReg color;
    public Imm stackOffset = null;
    public HashSet<Reg> adjList = new HashSet<>();
    public HashSet<Mv> moveList = new HashSet<>();

	public int isP;

    public Reg() {
        super();
        if (this instanceof PhyReg) color = (PhyReg)this;
        else color = null;
		this.isP = 0;
    }

    public void init() {
        moveList.clear();
        weight = 0;
    }
}
