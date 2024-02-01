public class Helper {
    public static boolean[] intToBooleanArray(int x) {
        String temp = Integer.toBinaryString(x);
        
        while (temp.length() < 16) {
            temp = "0" + temp;
        }
        
        while (temp.length() > 16) {
            temp = temp.substring(1);
        }
        
        int i = 0;
        boolean output[] = new boolean[16];
        while (i < 16) {
            output[i] = temp.charAt(i) == '1' ? true : false;
            i++;
        }
        
        return output;
    }
    
    public static int booleanArrayToint(boolean[] x) {
        String temp = "";
        
        int i = 15;
        while (i >= 0) {
            temp = (x[i] ? "1" : "0") + temp;
            i--;
        }
        
        return Integer.parseInt(temp, 2);
    }
}