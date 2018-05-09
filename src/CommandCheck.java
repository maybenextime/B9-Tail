import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Integer.max;


class CommandCheck {
    private String fileOut = "";
    private ArrayList<String> fileIn = new ArrayList<>();
    private int numbC = -1;
    private int numbN = -1;
    private boolean booleanC = false;
    private boolean booleanN = false;
    private boolean booleanO = false;

    String getFileOut() {
        return fileOut;
    }

    ArrayList<String> getFileIn() {
        return fileIn;
    }

    int getNumbC() {
        return numbC;
    }

    int getNumbN() {
        return numbN;
    }

    boolean isBooleanC() {
        return booleanC;
    }

    boolean isBooleanN() {
        return booleanN;
    }

    boolean isBooleanO() {
        return booleanO;
    }

    CommandCheck(String[] args) {
        if (args == null || args.length < 1) {
            return;
        }
        int indexN = 0;
        int indexC = 0;
        int indexO = 0;
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-c": {
                    indexC = i;
                    numbC = Integer.parseInt(args[i + 1]);
                    booleanC = true;
                    break;
                }
                case "-n": {
                    indexN = i;
                    numbN = Integer.parseInt(args[i + 1]);
                    booleanN = true;
                    break;
                }
                case "-o": {
                    booleanO = true;
                    indexO = i;
                    fileOut = args[i + 1];
                    break;
                }
            }
        }
        fileIn.addAll(Arrays.asList(args).subList(max(max(indexC, indexN), indexO) + 2, args.length));
        if (booleanC && booleanN) throw new IllegalArgumentException();
        if (!booleanC && !booleanN) {
            booleanN = true;
            numbN = 10;
        }
    }
}





