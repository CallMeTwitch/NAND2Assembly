public class FlipFlop {
    private Latch latch1, latch2;
    private Inverter inverter;
    private boolean output;
    private AND and1;
    private AND and2;
    
    public FlipFlop() {
        inverter = new Inverter();
        latch1 = new Latch();
        latch2 = new Latch();
        and1 = new AND();
        and2 = new AND();
        output = false;
    }
    
    public void update(boolean st, boolean d, boolean cl) {
        inverter.update(cl);
        and1.update(st, cl);
        and2.update(st, inverter.getValue());
        latch1.update(and2.getValue(), d);
        latch2.update(and1.getValue(), latch1.getValue());
        output = latch2.getValue();
    }
    
    public boolean getValue() {
        return output;
    }
}