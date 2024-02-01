public class Inverter {
    private boolean output;
    private NAND nand;
    
    public Inverter() {
        nand = new NAND();
        output = false;
    }
    
    public void update(boolean x) {
        nand.update(x, x);
        output = nand.getValue();
    }
    
    public boolean getValue() {
        return output;
    }
}