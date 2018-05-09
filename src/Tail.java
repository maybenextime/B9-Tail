import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.min;

public class Tail {
    /*private ArrayList<String> getLines(String FileName, int number) {
        ArrayList<String> list = new ArrayList<>();
        try {
            BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(FileName)));
            String line;
            while ((line = file.readLine()) != null) {
                list.add(line);
                if (list.size() > number) list.remove(0);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }*/

    private ArrayList<String> getLines(ArrayList<String> lines, int number) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = min(number, lines.size()); i > 0; i--) {
            list.add(lines.get(lines.size() - i));
        }
        return list;
    }

    /*private ArrayList<String> getChar(String FileName, int number) {
        ArrayList<String> list = new ArrayList<>();
        int count1 ;
        int count2 = 0;
        try {
            BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(FileName)));
            String line;
            while ((line = file.readLine()) != null) {
                list.add(line);
                count2 += line.length();
                while (count2 > number) {
                    count1 = list.get(0).length();
                    if (count2 - count1 > number) {
                        list.remove(0);
                        count2 -= count1;
                    } else {
                        list.set(0, list.get(0).substring(count2 - number));
                        count2 = number;
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }*/

    private ArrayList<String> getChar(ArrayList<String> lines, int numb) {
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

    private void printOut(String FileName, ArrayList<String> list) throws IOException {
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

    private ArrayList<String> listf = new ArrayList<>();

    Tail(String[] args) throws IOException {
        if (args == null || args.length < 1) {
            return;
        }
        CommandCheck command = new CommandCheck(args);
        Console c = System.console();
        ArrayList<ArrayList<String>> lineList = new ArrayList<>();
        if (command.getFileIn().isEmpty()) {
            Scanner scanner = new Scanner(System.in);
            String line;
            while (scanner.hasNextLine() && !(line = scanner.nextLine()).equals("")) {
                lineList.get(0).add(line);
            }
        } else {
            for (String filename : command.getFileIn()) {
                try {
                    BufferedReader file = new BufferedReader(new FileReader(filename));
                    ArrayList<String> text = new ArrayList<>();
                    String line;
                    while ((line = file.readLine()) != null) {
                        text.add(line);
                    }
                    file.close();
                    lineList.add(text);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        for (ArrayList<String> lineFile : lineList) {
            if (command.isBooleanC()) {
                listf.addAll(getChar(lineFile, command.getNumbC()));
            }
            if (command.isBooleanN()) {
                listf.addAll(getLines(lineFile, command.getNumbN()));
            }
            if (command.isBooleanO()) {
                printOut(command.getFileOut(), listf);
            } else {
                for (String aListf : listf) c.printf(aListf);
            }
        }
    }

    ArrayList<String> getListf() {
        return listf;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < listf.size() - 1; i++) {
            string.append(listf.get(i)).append("\n");
        }
        return string + listf.get(listf.size() - 1);
    }

    public static void main(String[] args) {
        try {
            Tail tail = new Tail(args);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}






