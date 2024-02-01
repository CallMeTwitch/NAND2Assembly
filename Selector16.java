public class Selector16 {
    private Selector[] selectors;
    private boolean[] output;
    
    public Selector16() {
        selectors = new Selector[16];
        output = new boolean[16];

        int i = 0;
        while (i < 16) {
            selectors[i] = new Selector();
            i++;
        }
    }
    
    public void update(boolean s, int d1, int d0) {
        boolean[] D1 = Helper.intToBooleanArray(d1);
        boolean[] D0 = Helper.intToBooleanArray(d0);
        
        int i = 15;
        while (i >= 0) {
            selectors[i].update(s, D1[i], D0[i]);
            output[i] = selectors[i].getValue();
            i--;
        }
    }
    
    public int getValue() {
        return Helper.booleanArrayToint(output);
    }
}