import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.Arrays;

public class AssemblerLanguage {
    private Computer computer;
    
    public AssemblerLanguage() {
        computer = new Computer();
    }
    
    public void run(String fileName) {
        int[] instructions = new int[Integer.parseInt("FFFF", 16) + 1];
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            String line = fileReader.readLine();
            
            boolean[] temp;
            int i, lineNum = 0;
            String[] destinations;
            String calculation, jumpCondition;
            while (line != null) {
                line = line.replaceAll("\\s+", "");
                i = line.indexOf("#", 0);
                if (i != -1) line = line.substring(0, i);
                
                temp = new boolean[16];
                i = line.indexOf("=", 0);
                if (i == -1) break;
                
                destinations = line.substring(0, i).split(",");
                temp[10] = Arrays.asList(destinations).contains("A");
                temp[11] = Arrays.asList(destinations).contains("D");
                temp[12] = Arrays.asList(destinations).contains("*A");
                
                temp[0] = true;
                temp[1] = true;
                temp[2] = true;

                line = line.substring(i + 1, line.length());
                i = line.indexOf(";", 0);
                if (i == -1) {
                    calculation = line;
                    jumpCondition = "";
                } else {
                    calculation = line.substring(0, i);
                    jumpCondition = line.substring(i + 1, line.length());
                }
                
                if (calculation.equals("D+A") || calculation.equals("A+D")) {
                    temp[5] = true;
                } else if (calculation.equals("D+*A") || calculation.equals("*A+D")) {
                    temp[3] = true;
                    temp[5] = true;
                } else if (calculation.equals("D&*A") || calculation.equals("*A&D")) {
                    temp[3] = true;
                } else if (calculation.equals("D-A")) {
                    temp[5] = true;
                    temp[6] = true;
                } else if (calculation.equals("D-*A")) {
                    temp[3] = true;
                    temp[5] = true;
                    temp[6] = true;
                } else if (calculation.equals("A-D")) {
                    temp[5] = true;
                    temp[6] = true;
                    temp[9] = true;
                } else if (calculation.equals("*A-D")) {
                    temp[3] = true;
                    temp[5] = true;
                    temp[6] = true;
                    temp[9] = true;
                } else if (calculation.equals("D+1") || calculation.equals("1+D")) {
                    temp[5] = true;
                    temp[7] = true;
                } else if (calculation.equals("A+1") || calculation.equals("1+A")) {
                    temp[5] = true;
                    temp[7] = true;
                    temp[9] = true;
                } else if (calculation.equals("*A+1") || calculation.equals("1+*A")) {
                    temp[3] = true;
                    temp[5] = true;
                    temp[7] = true;
                    temp[9] = true;
                } else if (calculation.equals("D-1")) {
                    temp[5] = true;
                    temp[6] = true;
                    temp[7] = true;
                } else if (calculation.equals("A-1")) {
                    temp[5] = true;
                    temp[6] = true;
                    temp[7] = true;
                    temp[9] = true;
                } else if (calculation.equals("*A-1")) {
                    temp[3] = true;
                    temp[5] = true;
                    temp[6] = true;
                    temp[7] = true;
                    temp[9] = true;
                } else if (calculation.equals("-D")) {
                    temp[5] = true;
                    temp[6] = true;
                    temp[8] = true;
                    temp[9] = true;
                } else if (calculation.equals("-A")) {
                    temp[5] = true;
                    temp[6] = true;
                    temp[8] = true;                
                } else if (calculation.equals("-*A")) {
                    temp[3] = true;
                    temp[5] = true;
                    temp[6] = true;
                    temp[8] = true;
                } else if (calculation.equals("-1")) {
                    temp[5] = true;
                    temp[6] = true;
                    temp[7] = true;
                    temp[8] = true;
                    temp[9] = true;
                } else if (calculation.equals("1")) {
                    temp[5] = true;
                    temp[7] = true;
                    temp[8] = true;
                    temp[9] = true;
                } else if (calculation.equals("D|A") || calculation.equals("A|D")) {
                    temp[7] = true;
                } else if (calculation.equals("D|*A") || calculation.equals("*A|D")) {
                    temp[3] = true;
                    temp[7] = true;
                } else if (calculation.equals("~D")) {
                    temp[6] = true;
                    temp[7] = true;
                } else if (calculation.equals("~A")) {
                    temp[6] = true;
                    temp[7] = true;
                    temp[9] = true;
                } else if (calculation.equals("~*A")) {
                    temp[3] = true;
                    temp[6] = true;
                    temp[7] = true;
                    temp[9] = true;
                } else if (calculation.equals("D")) {
                    temp[5] = true;
                    temp[8] = true;
                    temp[9] = true;
                } else if (calculation.equals("A")) {
                    temp[5] = true;
                    temp[8] = true;
                } else if (calculation.equals("*A")) {
                    temp[3] = true;
                    temp[5] = true;
                    temp[8] = true;
                } else if (calculation.equals("0")) {
                    temp[8] = true;
                } else {
                    temp = Helper.intToBooleanArray(Integer.parseInt(calculation));
                }
                
                if (jumpCondition.equals("JLT")) {
                    temp[13] = true;
                } else if (jumpCondition.equals("JEQ")) {
                    temp[14] = true;
                } else if (jumpCondition.equals("JGT")) {
                    temp[15] = true;
                } else if (jumpCondition.equals("JLE")) {
                    temp[13] = true;
                    temp[14] = true;
                } else if (jumpCondition.equals("JGE")) {
                    temp[13] = true;
                    temp[15] = true;
                } else if (jumpCondition.equals("JMP")) {
                    temp[13] = true;
                    temp[14] = true;
                    temp[15] = true;
                }
                
                instructions[lineNum] = Helper.booleanArrayToint(temp);
                line = fileReader.readLine();
                lineNum++;
            }
            computer.writeProgram(instructions);
            
            boolean done = false;
            while (!done) {
                done = computer.update(true);
                computer.update(false);
                computer.print();
            }
            
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}