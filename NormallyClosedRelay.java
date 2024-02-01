public class NormallyClosedRelay {
    private boolean output;

    public NormallyClosedRelay() {
        output = false;
    }

    public void update(boolean c, boolean in) {
        output = in && !c;
    }
    
    public boolean getValue() {
        return output;
    }
}
