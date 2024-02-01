public class NAND {
    private NormallyClosedRelay closedRelay;
    private NormallyOpenRelay openRelay;
    private boolean output;
    
    public NAND() {
        closedRelay = new NormallyClosedRelay();
        openRelay = new NormallyOpenRelay();
        output = false;
    }
    
    public void update(boolean a, boolean b) {
        openRelay.update(a, b);
        closedRelay.update(openRelay.getValue(), true);
        output = closedRelay.getValue();
    }
    
    public boolean getValue() {
        return output;
    }
}