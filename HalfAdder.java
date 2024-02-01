public class HalfAdder {
    private NAND nand1, nand2, nand3, nand4;
    private Inverter inverter;
    private boolean high, low;
    
    public HalfAdder() {
        inverter = new Inverter();
        nand1 = new NAND();
        nand2 = new NAND();
        nand3 = new NAND();
        nand4 = new NAND();
        high = false;
        low = false;
    }
    
    public void update(boolean a, boolean b) {
        nand1.update(a, b);
        nand2.update(a, nand1.getValue());
        nand3.update(nand1.getValue(), b);
        nand4.update(nand2.getValue(), nand3.getValue());
        low = nand4.getValue();
        
        inverter.update(nand1.getValue());
        high = inverter.getValue();        
    }
    
    public boolean[] getValues() {
        return new boolean[] {high, low};
    }
}