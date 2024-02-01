public class XOR16 {
    private boolean[] output;
    private XOR[] xors;
    
    public XOR16() {
        output = new boolean[16];
        xors = new XOR[16];

        int i = 0;
        while (i < 16) {
            xors[i] = new XOR();
            i++;
        }
    }
    
    public void update(int a, int b) {
        boolean[] A = Helper.intToBooleanArray(a);
        boolean[] B = Helper.intToBooleanArray(b);
        
        int i = 15;
        while (i >= 0) {
            xors[i].update(A[i], B[i]);
            output[i] = xors[i].getValue();
            i--;
        }
    }
    
    public int getValue() {
        return Helper.booleanArrayToint(output);
    }
}