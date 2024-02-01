public class OR16 {
    private boolean[] output;
    private OR[] ors;
    
    public OR16() {
        output = new boolean[16];
        ors = new OR[16];

        int i = 0;
        while (i < 16) {
            ors[i] = new OR();
            i++;
        }
    }
    
    public void update(int a, int b) {
        boolean[] A = Helper.intToBooleanArray(a);
        boolean[] B = Helper.intToBooleanArray(b);
        
        int i = 15;
        while (i >= 0) {
            ors[i].update(A[i], B[i]);
            output[i] = ors[i].getValue();
            i--;
        }
    }
    
    public int getValue() {
        return Helper.booleanArrayToint(output);
    }
}