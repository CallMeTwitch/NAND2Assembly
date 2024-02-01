public class Register16 {
    private FlipFlop[] flipflops;
    private boolean[] output;
    
    public Register16() {
        flipflops = new FlipFlop[16];
        output = new boolean[16];

        int i = 0;
        while (i < 16) {
            flipflops[i] = new FlipFlop();
            i++;
        }
    }
    
    public void update(boolean st, int x, boolean cl) {
        boolean[] X = Helper.intToBooleanArray(x);
        
        int i = 0;
        while (i < 16) {
            flipflops[i].update(st, X[i], cl);
            output[i] = flipflops[i].getValue();
            i++;
        }
    }
    
    public int getValue() {
        return Helper.booleanArrayToint(output);
    }
}