public class LessThanZero {
    private boolean output;
    
    public LessThanZero() {
        output = false;
    }
    
    public void update(int x) {
        boolean[] X = Helper.intToBooleanArray(x);
        output = X[0];
    }
    
    public boolean getValue() {
        return output;
    }
}