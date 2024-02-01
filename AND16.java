public class AND16 {
    private boolean[] output;
    private AND[] ands;
    
    public AND16() {
        output = new boolean[16];
        ands = new AND[16];

        int i = 0;
        while (i < 16) {
            ands[i] = new AND();
            i++;
        }
    }
    
    public void update(int a, int b) {
        boolean[] A = Helper.intToBooleanArray(a);
        boolean[] B = Helper.intToBooleanArray(b);
        
        int i = 15;
        while (i >= 0) {
            ands[i].update(A[i], B[i]);
            output[i] = ands[i].getValue();
            i--;
        }
    }
    
    public int getValue() {
        return Helper.booleanArrayToint(output);
    }
}