package Backend;

import Assembly.LFn;
import Assembly.LIRBlock;
import Assembly.LOperand.GReg;
import Assembly.LRoot;
import Assembly.RISCInst.RISCInst;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class AsmPrinter {

    private LRoot root;
    PrintStream out;
    private boolean rename;
    public AsmPrinter(LRoot root, PrintStream out, boolean rename) {
        this.root = root;
        this.out = out;
        this.rename = rename;
    }

    private ArrayList<LIRBlock> visitList = new ArrayList<>();
    private void collectWithRename(LFn fn) {
        int blockCnt = 0;
        Queue<LIRBlock> blocks = new LinkedList<>();
        blocks.add(fn.entryBlock());
        visitList.add(fn.entryBlock());
        while (!blocks.isEmpty()) {
            LIRBlock check = blocks.poll();
            if (rename) check.name ="." + fn.name() + "_b." + blockCnt++;
            check.successors.forEach(block -> {
                if (block != null && !visitList.contains(block)) {
                    blocks.add(block);
                    visitList.add(block);
                }
            });
        }
    }
    private HashSet<LIRBlock> visited = new HashSet<>();
    private void runForBlock(LIRBlock block) {
        if (visited.contains(block))return;
        visited.add(block);
        out.println(block.name + ": ");
        for (RISCInst inst = block.head; inst != null; inst = inst.next)
            out.println("\t" + inst.toString());
        if (block.next != null) runForBlock(block.next);
    }
    private void runForFn(LFn fn) {
        out.println("\t.globl\t" + fn.name());
        out.println("\t.p2align\t1");
        out.println(fn.name() + ":");
        visitList.clear();
        collectWithRename(fn);

        runForBlock(fn.entryBlock());
        visitList.forEach(block -> {
            if (!visited.contains(block) && !block.hasPrior) runForBlock(block);
        });
    }

    private void runForGlb(GReg reg) {
        out.println("\t.section\t.bss");
        out.println("\t.globl\t" + reg.name);
        out.println("\t.p2align\t2");
        out.println(reg.name + ":");
        out.println(".L" + reg.name + "$local:");
        out.println("\t.word\t0");
    }

    private void runForString(GReg reg, String value) {
        out.println("\t.section\t.rodata");
        out.println(reg.name + ":");
        String str = value.replace("\\", "\\\\");
        str = str.replace("\n", "\\n");
        str = str.replace("\0", "");
        str = str.replace("\t", "\\t");
        str = str.replace("\"", "\\\"");
        out.println("\t.asciz\t\"" + str + "\"");
    }

    public void run() {
        out.println("\t.text");
        root.functions().forEach(this::runForFn);
        root.globalRegs.forEach(this::runForGlb);
        root.strings.forEach(this::runForString);
    }
}
