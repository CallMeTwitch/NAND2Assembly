public class ALU {
    private Selector16 selector1, selector2, selector3, selector4;
    private ArithmeticUnit arithmetic;
    private LogicUnit logic;
    private int output;
    
    public ALU() {
        arithmetic = new ArithmeticUnit();
        selector1 = new Selector16();
        selector2 = new Selector16();
        selector3 = new Selector16();
        selector4 = new Selector16();
        logic = new LogicUnit();
        output = 0;
    }
    
    public void update(boolean u, boolean op1, boolean op0, boolean zx, boolean sw, int x, int y) {
        selector1.update(sw, y, x);
        selector2.update(zx, 0, selector1.getValue());
        selector3.update(sw, x, y);
        
        logic.update(op1, op0, selector2.getValue(), selector3.getValue());
        arithmetic.update(op1, op0, selector2.getValue(), selector3.getValue());
        selector4.update(u, arithmetic.getValue(), logic.getValue());
        
        output = selector4.getValue();
    }
    
    public int getValue() {
        return output;
    }
}