package Backend;

import Assembly.LFn;
import Assembly.LIRBlock;
import Assembly.LOperand.PhyReg;
import Assembly.LOperand.Reg;
import Assembly.LOperand.SLImm;
import Assembly.LOperand.VirtualReg;
import Assembly.LRoot;
import Assembly.RISCInst.*;
import static Assembly.RISCInst.RISCInst.CalCategory;
import static Assembly.RISCInst.RISCInst.CalCategory.*;

import java.util.*;

public class RegAlloc {
	private static class edge {
		Reg u, v;
		public edge(Reg u, Reg v){
			this.u = u;
			this.v = v;
		}
		@Override
		public boolean equals(Object o) {
			return (o instanceof edge && ((edge)o).u == u && ((edge)o).v == v);
		}
		@Override
		public int hashCode() {
			return u.toString().hashCode() ^ v.toString().hashCode();
		}
	}

	private HashSet<Reg> preColored;
	private LRoot root;
	private LFn currentFn;

	private HashSet<Reg> initial = new LinkedHashSet<>();
	
	private HashMap<Reg, Reg> mp = new HashMap<>();
	Queue<Reg> vregs = new LinkedList<>();
	
	private int stackLength = 0;

	public RegAlloc(LRoot root) {
		this.root = root;
		preColored = new HashSet<>(root.phyRegs());
	}

	private void useDefCollect(LFn fn) {
		fn.blocks().forEach(block ->{
			double weight = Math.pow(10, block.loopDepth);
			for (RISCInst inst = block.head; inst != null; inst = inst.next) {
				inst.uses().forEach(reg -> reg.weight += weight);
				if (inst.dest() != null) inst.dest().weight += weight;
			}
		});
	}

	private void init() {
		initial.clear();
		currentFn.blocks().forEach(block -> {
			for (RISCInst inst = block.head; inst != null; inst = inst.next){
				initial.addAll(inst.defs());
				initial.addAll(inst.uses());
			}
		});
		initial.removeAll(preColored);
		initial.forEach(reg -> {
			reg.weight = 0;
			reg.alias = null;
			reg.color = null;
			reg.degree = 0;
			reg.adjList.clear();
			reg.moveList.clear();
		});

		preColored.forEach(reg -> {
			reg.degree = 0;
			reg.color = (PhyReg)reg;
			reg.alias = null;
			reg.adjList.clear();
			reg.moveList.clear();
		});
		useDefCollect(currentFn);
	}
	private void runForFn(LFn fn){
		init();
		initial.forEach(v -> {
			
//System.err.print(v.toString()+" ");
//System.err.println(-1 * stackLength - 4+96);			

			v.stackOffset = new SLImm(-1 * stackLength - 4);
			stackLength += 4;
		});

		currentFn.blocks().forEach(block -> {	
			for (RISCInst inst = block.head; inst != null; inst = inst.next) {
				for (Reg reg : inst.uses()) {
					if (reg.stackOffset != null) {
	
						if (inst.defs().contains(reg)) {					
System.err.println("notice: " + inst.toString() +"\n\n");
							vregs.offer(reg);	
						}
						else {
							if (inst instanceof Mv && ((Mv)inst).origin() == reg && inst.dest().stackOffset == null) {//safe for only one reg
								RISCInst replace = new Ld(root.getPhyReg(2), inst.dest(), reg.stackOffset, ((VirtualReg)reg).size(), block);
//System.err.println("dest:" + inst.dest().toString() + " inst: " + inst.toString());
								inst.replaceBy(replace); inst = replace;
							} else {								
								if(reg.isP == 1)
								{
									if(inst instanceof St && ((St)inst).address == reg){
										((St)inst).address = root.getPhyReg(2);
										((St)inst).offset = reg.stackOffset;
									}
									else if(inst instanceof Ld && ((Ld)inst).address == reg){
										((Ld)inst).address = root.getPhyReg(2);
										((Ld)inst).offset = reg.stackOffset;
									}
								}
								vregs.offer(reg);	
								if(inst.isF == 0 ){
									RISCInst _tmp = new Ld(root.getPhyReg(2), reg, reg.stackOffset, ((VirtualReg)reg).size(), block);
									_tmp.isF = 1;
									inst.addPre(_tmp);
									System.err.println("load: " + inst.toString());
								}

							}
						}
					}
				}
				for (Reg def : inst.defs()) {
					if (def.stackOffset != null) {
						if (!inst.uses().contains(def)) {
							if (inst instanceof Mv && ((Mv) inst).origin().stackOffset == null){
								RISCInst replace = new St(root.getPhyReg(2), ((Mv) inst).origin(), def.stackOffset, ((VirtualReg)def).size(), block);
//System.err.println("origin:" + ((Mv) inst).origin().toString() + " inst: " + ((Mv) inst).toString());
								inst.replaceBy(replace); inst = replace;
							}
							else {
								
								vregs.offer(def);
								if(inst.isF == 0){
									RISCInst _tmp = new St(root.getPhyReg(2), def, def.stackOffset, ((VirtualReg)def).size(), block);
									_tmp.isF = 1;
									inst.addPost(_tmp);
									System.err.println("store: " + inst.toString());	
								}

						   }
						}
					}
				}
			}
		});
///*	
		Queue<Reg> pregs = new LinkedList<>(root.assignableRegs());
		vregs.forEach(v -> {
			Reg p = mp.get(v);
			if(p != null){
				v.color = (PhyReg)p;
			}
			else{
				p = pregs.poll();
				v.color = (PhyReg)p;
				mp.put(v, p);
				pregs.offer(p);
			}
		});
//*/
	}

	private void subtleModify() {
		currentFn.blocks().forEach(block -> {
			for (RISCInst inst = block.head; inst != null; inst = inst.next)
				inst.stackLengthAdd(stackLength);
		});
/*
		currentFn.blocks().forEach(block -> {
			for (RISCInst inst = block.head; inst != null; inst = inst.next){
				if (inst instanceof Mv && (((Mv) inst).origin().color == inst.dest().color)) inst.removeSelf();
			}
		}
		);
*/
		HashSet<LIRBlock> canMix = new HashSet<>();
		currentFn.blocks().forEach(block -> {
			if (block.head instanceof Jp) canMix.add(block);
		});
		canMix.forEach(block -> {
			LIRBlock suc = block;
			do {
				suc = ((Jp)suc.head).destBlock();
			}
			while (canMix.contains(suc));
			for (LIRBlock pre : block.precursors) {
				for (RISCInst inst = pre.head; inst != null; inst = inst.next) {
					if (inst instanceof Jp) ((Jp) inst).replaceDest(block, suc);
					else if (inst instanceof Br) ((Br) inst).replaceDest(block, suc);
					else if (inst instanceof Bz) ((Bz) inst).replaceDest(block, suc);
				}
				pre.successors.remove(block);
				pre.successors.add(suc);
			}
			suc.precursors.remove(block);
			suc.precursors.addAll(block.precursors);
			if (currentFn.entryBlock == block) currentFn.entryBlock = suc;
		});
		currentFn.blocks().removeAll(canMix);
	}
	private void reschedule() {
		HashSet<LIRBlock> visited = new HashSet<>();
		Queue<LIRBlock> queue = new LinkedList<>();
		queue.add(currentFn.entryBlock);
		visited.add(currentFn.entryBlock);
		do {
			LIRBlock currentBlock = queue.poll();
			assert currentBlock != null;
			if (currentBlock.tail instanceof Jp) {
				assert currentBlock.next == null;
				Jp jp = (Jp) currentBlock.tail;
				if (!jp.destBlock().hasPrior) {
					currentBlock.next = jp.destBlock();
					jp.destBlock().hasPrior = true;
					currentBlock.tail = jp.previous;
					currentBlock.tail.next = null;
					jp.previous = null;
				}
			}
			currentBlock.successors.forEach(suc -> {
				if (!visited.contains(suc)) queue.offer(suc);
			});
			visited.addAll(currentBlock.successors);
		}
		while(!queue.isEmpty());
	}
	public void run() {
		root.functions().forEach(fn -> {
			stackLength = 0;
			currentFn = fn;
			runForFn(fn);
			stackLength += fn.paramOffset;
			if (stackLength % 16 != 0) stackLength = (stackLength / 16 + 1) * 16;
			subtleModify();
			reschedule();
		});
	}
}
