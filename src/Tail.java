import java.io.*;
import java.util.ArrayList;
import static java.lang.Integer.min;

public class Tail {
    private ArrayList<String> ReadFile(String FileName) throws IOException {
        ArrayList<String> LinesList = new ArrayList<>();
        try {
            BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(FileName)));
            String line;
            while ((line = file.readLine()) != null) {
                LinesList.add(line);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return LinesList;
    }

    private ArrayList<String> GetLines(ArrayList<String> lines, int numb) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = min(numb, lines.size()); i > 0; i--) {
            list.add(lines.get(lines.size() - i));
        }
        return list;
    }

    private ArrayList<String> GetChar(ArrayList<String> lines, int numb) {
        int count = 0;
        int NumbCharFile = 0;
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < lines.size() - 1; i++) {
            NumbCharFile += lines.get(i).length();
        }
        for (int i = lines.size() - 1; count < min(numb, NumbCharFile); i--) {
            count += lines.get(i).length();
            if (count > numb) {
                list.add(lines.get(i).substring(count - numb));
            } else list.add(lines.get(i));
        }
        ArrayList<String> list2 = new ArrayList<>();
        for (int i = list.size() - 1; i > -1; i--) {
            list2.add(list.get(i));
        }

        return list2;
    }

    private void PrintOut(String FileName, ArrayList<String> list) throws IOException {
        try {
            BufferedWriter fileout = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FileName)));
            for (String aList : list) {
                fileout.write(aList + "\n");
            }
            fileout.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<String> listf = new ArrayList<>();

    public Tail(String[] args) throws IOException {
        CommandCheck cm = new CommandCheck(args);
        for (int i = 0; i < cm.FileIn.size(); i++) {
            if (cm.booc) {
                listf.addAll(GetChar(ReadFile(cm.FileIn.get(i)), cm.numbc));
            }
            if (cm.boon) {
                listf.addAll(GetLines(ReadFile(cm.FileIn.get(i)), cm.numbn));
            }
        }
        if (cm.booo) {
            PrintOut(cm.FileOut, listf);
        } else {
            for (String aListf : listf) System.out.println(aListf);
        }
    }
    public ArrayList<String> GetListf() {
        return listf;
    }

    @Override
    public String toString() {
        String string = "";
        for (int i = 0; i < listf.size() - 1; i++) {
            string += listf.get(i) + "\n";
        }
        return string + listf.get(listf.size() - 1);
    }

    public static void main(String[] args) {
        try {
            Tail tail = new Tail(args);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


}



