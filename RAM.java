public class RAM {
    private Register16 register1, register2;
    private Selector16 selector;
    private Switch switcher;
    private int output;
    
    public RAM() {
        register1 = new Register16();
        register2 = new Register16();
        selector = new Selector16();
        switcher = new Switch();
        output = 0;
    }
    
    public void update(boolean ad, boolean st, int x, boolean cl) {
        switcher.update(ad, st);
        register1.update(switcher.getValues()[0], x, cl);
        register2.update(switcher.getValues()[1], x, cl);
        selector.update(ad, register1.getValue(), register2.getValue());
        output = selector.getValue();
    }
    
    public int getValue() {
        return output;
    }
}