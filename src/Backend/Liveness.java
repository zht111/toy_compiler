package Backend;

import Assembly.LFn;
import Assembly.LIRBlock;
import Assembly.LOperand.Reg;
import Assembly.RISCInst.RISCInst;

import java.util.HashMap;
import java.util.HashSet;

public class Liveness {
	private LFn fn;
	private HashMap<LIRBlock, HashSet<Reg> > Use = new HashMap<>(),
											 Def = new HashMap<>();
	private HashSet<LIRBlock> visited = new HashSet<>();
	public Liveness(LFn _fn){
		fn = _fn;
	}
	public void run_block(LIRBlock block) { 
		HashSet<Reg> uses = new HashSet<>();
		HashSet<Reg> defs = new HashSet<>();		
		for (RISCInst inst = block.head; inst != null; inst = inst.next) {
			
			HashSet<Reg> tmp = inst.uses();
			tmp.removeAll(defs);
			uses.addAll(tmp);
			defs.addAll(inst.defs());
		}
		Use.put(block, uses);
		Def.put(block, defs);
		block.liveIn.clear();
		block.liveOut.clear();
	}
	public void LiveIO(LIRBlock block) {
		visited.add(block);
		HashSet<Reg> liveOut = new HashSet<>();
		block.successors.forEach(suc -> liveOut.addAll(suc.liveIn));
		HashSet<Reg> liveIn = new HashSet<>(liveOut);
		liveIn.removeAll(Def.get(block));
		liveIn.addAll(Use.get(block));
		block.liveOut.addAll(liveOut);
		liveIn.removeAll(block.liveIn);
		if (!liveIn.isEmpty()) {
			block.liveIn.addAll(liveIn);
			visited.removeAll(block.precursors);
		}
		block.precursors.forEach(pre -> {
			if (!visited.contains(pre)) LiveIO(pre);
		});
	}
	public void run_fn() {
		fn.blocks().forEach(this::run_block);
		LiveIO(fn.exitBlock());
	}
}