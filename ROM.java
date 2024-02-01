public class ROM {
    private Register16[] registers;
    private int output;
    
    public ROM() {
        registers = new Register16[Integer.parseInt("FFFF", 16) + 1];
        output = 0;
    }
    
    public void writeProgram(int[] program) {
        int i = 0;
        while (i < program.length) {
            registers[i] = new Register16();
            registers[i].update(true, program[i], false);
            registers[i].update(true, program[i], true);
            i++;
        }
    }
    
    public boolean update(int ad) {
        if (registers[ad] == null) registers[ad] = new Register16();
        output = registers[ad].getValue();
        
        return (output == 0);
    }
    
    public int getValue() {
        //System.out.println("ROM: " + output);
        return output;
    }
}