package Assembly.LOperand;

public class GReg extends Reg {

    private int size;
    public String name;
    public GReg(int size, String name) {
        super();
        this.size = size;
        this.name = name;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return name;
    }
}
