public class EqualZero {
    private Inverter inverter;
    private boolean output;
    private OR or;
    
    public EqualZero() {
        inverter = new Inverter();
        output = false;
        or = new OR();
    }
    
    public void update(int x) {
        boolean[] X = Helper.intToBooleanArray(x);
        
        int i = 0;
        boolean temp = false;
        while (i < 16) {
            or.update(temp, X[i]);
            temp = or.getValue();
            i++;
        }

        inverter.update(temp);
        output = inverter.getValue();
    }
    
    public boolean getValue() {
        return output;
    }
}