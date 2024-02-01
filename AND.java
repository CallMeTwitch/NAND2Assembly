public class AND {
    private Inverter inverter;
    private boolean output;
    private NAND nand;
    
    public AND() {
        inverter = new Inverter();
        nand = new NAND();
        output = false;
    }
    
    public void update(boolean a, boolean b) {
        nand.update(a, b);
        inverter.update(nand.getValue());
        output = inverter.getValue();
    }
    
    public boolean getValue() {
        return output;
    }
}