public class ArithmeticUnit {
    private Selector16 selector1, selector2;
    private Subtract16 subtract;
    private int output;
    private Add16 add;
    
    public ArithmeticUnit() {
        selector1 = new Selector16();
        selector2 = new Selector16();
        subtract = new Subtract16();
        add = new Add16();
        output = 0;
    }
    
    public void update(boolean op1, boolean op0, int x, int y) {
        selector1.update(op0, 1, y);
        add.update(x, selector1.getValue(), false);
        subtract.update(x, selector1.getValue());
        selector2.update(op1, subtract.getValue(), (int)add.getValues()[1]);
        output = selector2.getValue();
    }
    
    public int getValue() {
        return output;
    }
}