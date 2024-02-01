public class Subtract16 {
    private Increment16 increment;
    private Inverter16 inverter;
    private int output;
    private Add16 add;
    
    public Subtract16() {
        increment = new Increment16();
        inverter = new Inverter16();
        add = new Add16();
        output = 0;
    }
    
    public void update(int a, int b) {
        inverter.update(b);
        increment.update(inverter.getValue());
        add.update(a, increment.getValue(), false);
        output = (int)add.getValues()[1];
    }
    
    public int getValue() {
        return output;
    }
}