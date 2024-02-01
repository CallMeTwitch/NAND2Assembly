public class RAM16 {
    private Register16[] registers;
    private int output;
    
    public RAM16() {
        registers = new Register16[Integer.parseInt("FFFF", 16) + 1];
        output = 0;
    }
    
    public void update(boolean st, int x, int ad, boolean cl) {
        int i = 0;
        while (i < registers.length) {
            if (registers[i] == null) registers[i] = new Register16();
            
            if (i == ad) {
                registers[i].update(st, x, cl);
            } else {
                registers[i].update(false, x, cl);
            }
            i++;
        }
        
        output = registers[ad].getValue();
    }
    
    public int getValue() {
        return output;
    }
    
    public void print() {
        if (registers[registers.length - 1].getValue() != 0) {
            System.out.println("Program Output: " + registers[registers.length - 1].getValue());
        }
    }
}