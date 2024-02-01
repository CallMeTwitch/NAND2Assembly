public class Latch {
    private Selector selector;
    private boolean output;
    
    public Latch() {
        selector = new Selector();
        output = false;
    }
    
    public void update(boolean st, boolean d) {
        selector.update(st, d, selector.getValue());
        output = selector.getValue();
    }
    
    public boolean getValue() {
        return output;
    }
}