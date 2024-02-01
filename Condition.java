public class Condition {
    private NAND nand1, nand2, nand3, nand4;
    private Inverter inverter;
    private LessThanZero neg;
    private EqualZero zero;
    private AND and;
    boolean output;
    private OR or;
    
    public Condition() {
        inverter = new Inverter();
        neg = new LessThanZero();
        zero = new EqualZero();
        nand1 = new NAND();
        nand2 = new NAND();
        nand3 = new NAND();
        nand4 = new NAND();
        and = new AND();
        output = false;
        or = new OR();
    }
    
    public void update(boolean lt, boolean eq, boolean gt, int x) {
        zero.update(x);
        neg.update(x);
        nand1.update(lt, neg.getValue());
        nand2.update(eq, zero.getValue());
        or.update(neg.getValue(), zero.getValue());
        
        inverter.update(or.getValue());
        and.update(nand1.getValue(), nand2.getValue());
        nand3.update(gt, inverter.getValue());
        nand4.update(and.getValue(), nand3.getValue());
        
        output = nand4.getValue();
    }
    
    public boolean getValue() {
        return output;
    }
}