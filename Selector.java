public class Selector {
    private NAND nand1, nand2, nand3, nand4;
    private boolean output;
    
    public Selector() {
        nand1 = new NAND();
        nand2 = new NAND();
        nand3 = new NAND();
        nand4 = new NAND();
        output = false;
    }
    
    public void update(boolean s, boolean d1, boolean d0) {
        nand1.update(s, d1);
        nand2.update(s, s);
        nand3.update(nand2.getValue(), d0);
        nand4.update(nand1.getValue(), nand3.getValue());
        output = nand4.getValue();
    }
    
    public boolean getValue() {
        return output;
    }
}