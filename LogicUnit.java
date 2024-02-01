public class LogicUnit {
    private Selector16 selector1, selector2, selector3;
    private Inverter16 inverter;
    private int output;
    private XOR16 xor;
    private AND16 and;
    private OR16 or;
    
    public LogicUnit() {
        selector1 = new Selector16();
        selector2 = new Selector16();
        selector3 = new Selector16();
        inverter = new Inverter16();
        xor = new XOR16();
        and = new AND16();
        or = new OR16();
        output = 0;
    }
    
    public void update(boolean op1, boolean op0, int x, int y) {
        inverter.update(x);
        xor.update(x, y);
        and.update(x, y);
        or.update(x, y);
        
        selector1.update(op0, or.getValue(), and.getValue());
        selector2.update(op0, inverter.getValue(), xor.getValue());
        selector3.update(op1, selector2.getValue(), selector1.getValue());
                
        output = selector3.getValue();
    }
    
    public int getValue() {
        return output;
    }
}