import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import static java.lang.Integer.max;


public class CommandCheck {
    public String FileOut = "";
    public ArrayList<String> FileIn = new ArrayList<>();
    public int numbc = -1;
    public int numbn = -1;
    public boolean booc = false;
    public boolean boon = false;
    public boolean booo = false;
    private String flagc = "-c";
    private String flagn = "-n";
    private String flago = "-o";

    private int IndexFlag(String args[], String flag) {
        for (int i = 0; i < args.length; i++) {
            if (Objects.equals(args[i], flag)) {
                return i;
            }
        }
        return -1;
    }

    public CommandCheck(String command) throws IOException {
        String[] args = command.split(" ");
        if (!Objects.equals(args[0], "tail")) throw new IOException();
        else {
            int indexc = IndexFlag(args, flagc);
            int indexn = IndexFlag(args, flagn);
            int indexo = IndexFlag(args, flago);
            if (indexc != -1 && indexn != -1) throw new IOException();
            else {
                if (indexc != -1) {
                    numbc = Integer.parseInt(args[indexc + 1]);
                    booc = true;
                }
                if (indexn != -1) {
                    numbn = Integer.parseInt(args[indexn + 1]);
                    boon = true;
                }
                if (indexo != -1) {
                    FileOut = args[indexo + 1];
                    booo = true;
                }
                if (indexc == -1 && indexn == -1) {
                    boon = true;
                    numbn = 10;
                }
                for (int i = max(max(indexc, indexn), indexo) + 2; i < args.length; i++) {
                    FileIn.add(args[i]);
                }
            }
        }
    }


}

