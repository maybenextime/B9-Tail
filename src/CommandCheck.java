import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
    public CommandCheck(String[] args) throws IOException {
        if (!Objects.equals(args[0], "tail")) throw new IOException();
        int indexn = 0;
        int indexc = 0;
        int indexo = 0;
        for (int i = 1; i < args.length; i++) {
            switch (args[i]) {
                case "-c": {
                    indexc = i;
                    numbc = Integer.parseInt(args[i + 1]);
                    booc = true;
                    break;
                }
                case "-n": {
                    indexn = i;
                    numbn = Integer.parseInt(args[i + 1]);
                    boon = true;
                    break;
                }
                case "-o": {
                    booo = true;
                    indexo = i;
                    FileOut = args[i + 1];
                    break;
                }
            }
        }
        FileIn.addAll(Arrays.asList(args).subList(max(max(indexc, indexn), indexo) + 2, args.length));
        if (booc && boon) throw new IOException();
        if (!booc && !boon) {
            boon = true;
            numbn = 10;
        }
    }

}





