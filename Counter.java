public class Counter {
    private Increment16 increment;
    private Register16 register;
    private Selector16 selector;
    private int output;
    
    public Counter() {
        increment = new Increment16();
        register = new Register16();
        selector = new Selector16();
        output = 0; 
    }
    
    public void update(boolean st, int x, boolean cl) {
        increment.update(register.getValue());
        selector.update(st, x, increment.getValue());
        register.update(true, selector.getValue(), cl);
        output = register.getValue();
    }
    
    public int getValue() {
        return output;
    }
}