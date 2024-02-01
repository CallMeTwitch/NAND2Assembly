public class Computer {
    private CombinedMemory combinedMemory;
    private ControlUnit controlUnit;
    private Counter counter;
    public boolean done;
    private ROM rom;
    
    public Computer() {
        combinedMemory = new CombinedMemory();
        controlUnit = new ControlUnit();
        counter = new Counter();
        rom = new ROM();
        done = false;
    }
    
    public void writeProgram(int[] program) {
        rom.writeProgram(program);
    }
    
    public boolean update(boolean cl) {
        combinedMemory.update((boolean)controlUnit.getValues()[1], (boolean)controlUnit.getValues()[2], (boolean)controlUnit.getValues()[3], (int)controlUnit.getValues()[0], cl);
        counter.update((boolean)controlUnit.getValues()[4], combinedMemory.getValues()[0], cl);
        done = rom.update(counter.getValue());
        controlUnit.update(rom.getValue(), combinedMemory.getValues()[0], combinedMemory.getValues()[1], combinedMemory.getValues()[2]);
        return done;
    }
    
    public void print() {
        combinedMemory.print();
    }
}