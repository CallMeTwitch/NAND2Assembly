public class Add16 {
    private FullAdder[] adders;
    private boolean[] output;
    private boolean carry;
    
    public Add16() {
        adders = new FullAdder[16];
        output = new boolean[16];
        carry = false;

        int i = 0;
        while (i < 16) {
            adders[i] = new FullAdder();
            i++;
        }
    }
    
    public void update(int a, int b, boolean carry) {
        boolean[] A = Helper.intToBooleanArray(a);
        boolean[] B = Helper.intToBooleanArray(b);
        
        int i = 15;
        while (i >= 0) {
            adders[i].update(A[i], B[i], carry);
            output[i] = adders[i].getValues()[1];
            carry = adders[i].getValues()[0];
            i--;
        }
    }
    
    public Object[] getValues() {
        return new Object[] {carry, Helper.booleanArrayToint(output)};
    }
}