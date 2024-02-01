public class OR {
    private Inverter inverter1, inverter2;
    private boolean output;
    private NAND nand;
    
    public OR () {
        inverter1 = new Inverter();
        inverter2 = new Inverter();
        nand = new NAND();
        output = false;
    }
    
    public void update(boolean a, boolean b) {
        inverter1.update(a);
        inverter2.update(b);
        nand.update(inverter1.getValue(), inverter2.getValue());
        output = nand.getValue();
    }
    
    public boolean getValue() {
        return output;
    }
}