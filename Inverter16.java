public class Inverter16 {
    private Inverter[] inverters;
    private boolean[] output;
    
    public Inverter16() {
        inverters = new Inverter[16];
        output = new boolean[16];

        int i = 0;
        while (i < 16) {
            inverters[i] = new Inverter();
            i++;
        }
    }
    
    public void update(int x) {
        boolean[] X = Helper.intToBooleanArray(x);
        
        int i = 15;
        while (i >= 0) {
            inverters[i].update(X[i]);
            output[i] = inverters[i].getValue();
            i--;
        }
    }
    
    public int getValue() {
        return Helper.booleanArrayToint(output);
    }
}