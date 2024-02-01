public class FullAdder {
    private NAND nand1, nand2, nand3, nand4, nand5, nand6, nand7, nand8, nand9;
    private boolean high, low;
    
    public FullAdder() {
        nand1 = new NAND();
        nand2 = new NAND();
        nand3 = new NAND();
        nand4 = new NAND();
        nand5 = new NAND();
        nand6 = new NAND();
        nand7 = new NAND();
        nand8 = new NAND();
        nand9 = new NAND();
        high = false;
        low = false;
    }
    
    public void update(boolean a, boolean b, boolean c) {
        nand1.update(a, b);
        nand2.update(a, nand1.getValue());
        nand3.update(nand1.getValue(), b);
        nand4.update(nand2.getValue(), nand3.getValue());
        nand5.update(nand4.getValue(), c);
        nand6.update(nand4.getValue(), nand5.getValue());
        nand7.update(nand5.getValue(), c);
        nand8.update(nand6.getValue(), nand7.getValue());
        low = nand8.getValue();
        
        nand9.update(nand1.getValue(), nand5.getValue());
        high = nand9.getValue();
    }
    
    public boolean[] getValues() {
        return new boolean[] {high, low};
    }
}