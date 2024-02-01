public class NormallyOpenRelay {
    private boolean output;

    public NormallyOpenRelay() {
        output = false;
    }

    public void update(boolean c, boolean in) {
        output = in && c;
    }
    
    public boolean getValue() {
        return output;
    }
}
