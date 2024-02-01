public class ControlUnit {
    private Selector selector1, selector2, selector3, selector4;
    private Instruction instruction;
    private boolean a, d, aStar, j;
    private Selector16 selector16;
    private int r;
    
    public ControlUnit() {
        instruction = new Instruction();
        selector16 = new Selector16();
        selector1 = new Selector();
        selector2 = new Selector();
        selector3 = new Selector();
        selector4 = new Selector();
        aStar = false;
        a = false;
        d = false;
        j = false;
        r = 0;
    }
    
    public void update(int i, int a, int d, int aStar) {
        boolean[] I = Helper.intToBooleanArray(i);
        instruction.update(i, a, d, aStar);
        
        selector16.update(I[0], (int)instruction.getValues()[0], i);
        selector1.update(I[0], (boolean)instruction.getValues()[1], true);
        selector2.update(I[0], (boolean)instruction.getValues()[2], false);
        selector3.update(I[0], (boolean)instruction.getValues()[3], false);
        selector4.update(I[0], (boolean)instruction.getValues()[4], false);
        
        r = selector16.getValue();
        this.a = selector1.getValue();
        this.d = selector2.getValue();
        this.aStar = selector3.getValue();
        j = selector4.getValue();
    }
    
    public Object[] getValues() {
        return new Object[] {r, a, d, aStar, j};
    }
}