public class XOR {
    private NAND nand1, nand2, nand3, nand4;
    private boolean output;
    
    public XOR() {
        nand1 = new NAND();
        nand2 = new NAND();
        nand3 = new NAND();
        nand4 = new NAND();
        output = false;
    }
    
    public void update(boolean a, boolean b) {
        nand1.update(a, b);
        nand2.update(a, nand1.getValue());
        nand3.update(nand1.getValue(), b);
        nand4.update(nand2.getValue(), nand3.getValue());
        output = nand4.getValue();
    }
    
    public boolean getValue() {
        return output;
    }
}