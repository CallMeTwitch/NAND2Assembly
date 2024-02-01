public class CombinedMemory {
    private Register16 register1, register2;
    private int A, D, A_STAR;
    private RAM16 ram;
    
    public CombinedMemory() {
        register1 = new Register16();
        register2 = new Register16();
        ram = new RAM16();
        A_STAR = 0;
        A = 0;
        D = 0;
    }
    
    public void update(boolean a, boolean d, boolean aStar, int x, boolean cl) {
        register1.update(a, x, cl);
        register2.update(d, x, cl);
        ram.update(aStar, x, register1.getValue(), cl);
        A = register1.getValue();
        D = register2.getValue();
        A_STAR = ram.getValue();
    }
    
    public int[] getValues() {
        return new int[] {A, D, A_STAR};
    }
    
    public void print() {
        ram.print();
    }
}