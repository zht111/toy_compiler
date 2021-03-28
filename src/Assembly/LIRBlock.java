package Assembly;

import Assembly.LOperand.Reg;
import Assembly.RISCInst.RISCInst;

import java.util.ArrayList;
import java.util.HashSet;

public class LIRBlock {

    public ArrayList<LIRBlock> precursors = new ArrayList<>();
    public ArrayList<LIRBlock> successors = new ArrayList<>();
    public HashSet<Reg> liveIn = new HashSet<>(), liveOut = new HashSet<>();
    public RISCInst head = null, tail = null;
    public int loopDepth;
    public String name;
    public LIRBlock next = null;
    public boolean hasPrior = false;

    public LIRBlock(int loopDepth, String name) {
        this.loopDepth = loopDepth;
        this.name = name;
    }

    public void addInst(RISCInst inst) {
        if (head == null) head = inst;
         else {
            tail.next = inst;
            inst.previous = tail;
        }
        tail = inst;
		showlast();
    }
	
	public void showlast() {
		if(tail != null){
			System.err.println(">> " + tail.toString());
		}
	}

    @Override
    public String toString() {
        return name;
    }
}
