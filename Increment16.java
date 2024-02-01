public class Increment16 {
    private int output;
    private Add16 add;
    
    public Increment16() {
        add = new Add16();
        output = 0;
    }
    
    public void update(int x) {
        add.update(x, 1, false);
        output = (int)add.getValues()[1];
    }
    
    public int getValue() {
        return output;
    }
}