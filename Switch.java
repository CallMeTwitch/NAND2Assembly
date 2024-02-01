public class Switch {
    private NAND nand1, nand2, nand3, nand4;
    private boolean c0, c1;
    
    public Switch() {
        nand1 = new NAND();
        nand2 = new NAND();
        nand3 = new NAND();
        nand4 = new NAND();
        c1 = false;
        c0 = false;
    }
    
    public void update(boolean s, boolean d) {
        nand1.update(s, d);
        nand2.update(nand1.getValue(), d);
        nand3.update(nand1.getValue(), nand1.getValue());
        nand4.update(nand2.getValue(), nand2.getValue());
        
        c1 = nand3.getValue();
        c0 = nand4.getValue();
    }
    
    public boolean[] getValues() {
        return new boolean[] {c1, c0};
    }
}