public class MultiBitAdder {
    private boolean carry, s1, s0;
    private FullAdder add1;
    private FullAdder add2;
    
    public MultiBitAdder() {
        add1 = new FullAdder();
        add2 = new FullAdder();
        carry = false;
        s1 = false;
        s0 = false;
    }
    
    public void update(boolean a0, boolean a1, boolean b0, boolean b1, boolean carry) {
        add1.update(a0, b0, carry);
        s0 = add1.getValues()[1];
        
        add2.update(a1, b1, add1.getValues()[0]);
        carry = add2.getValues()[0];
        s1 = add2.getValues()[1];
    }
    
    public boolean[] getValues() {
        return new boolean[] {carry, s1, s0};
    }
}