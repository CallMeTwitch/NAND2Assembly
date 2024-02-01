public class Instruction {
    private boolean a, d, aStar, j;
    private Condition condition;
    private Selector16 selector;
    private ALU alu;
    private int r;
    
    public Instruction() {
        condition = new Condition();
        selector = new Selector16();
        alu = new ALU();
        aStar = false;
        a = false;
        d = false;
        j = false;
        r = 0;
    }
    
    public void update(int i, int a, int d, int aStar) {
        boolean[] I = Helper.intToBooleanArray(i);
        selector.update(I[3], aStar, a);
        alu.update(I[5], I[6], I[7], I[8], I[9], d, selector.getValue());
        condition.update(I[13], I[14], I[15], alu.getValue());
        
        r = alu.getValue();
        this.aStar = I[12];
        this.a = I[10];
        this.d = I[11];
        j = condition.getValue();
    }
    
    public Object[] getValues() {
        return new Object[] {r, a, d, aStar, j};
    }
}