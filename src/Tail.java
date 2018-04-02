

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import static java.lang.Integer.min;

public class Tail {
    private ArrayList<String> ReadFile(String FileName) throws IOException {
        ArrayList<String> lines = new ArrayList<String>();
        BufferedReader file = new BufferedReader(new FileReader(FileName));
        String line = "";
        while ((line = file.readLine()) != null)
            lines.add(line);
        return lines;
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

    private void PrintOut(String name, ArrayList<String> list) throws IOException {
        PrintWriter fileout = new PrintWriter(name);
        for (int i = 0; i < list.size(); i++) {
            fileout.println(list.get(i));
        }
        fileout.close();
    }

    public ArrayList<String> listf = new ArrayList<String>();

    public Tail(String command) throws IOException {
        String folder = "C:\\Users\\Pikachu\\IdeaProjects\\Tail\\src\\";
        CommandCheck cm = new CommandCheck(command);
        for (int i = 0; i < cm.FileIn.size(); i++) {
            if (cm.booc) {

                listf.addAll(GetChar(ReadFile(folder + cm.FileIn.get(i)), cm.numbc));
            }
            if (cm.boon) {
                listf.addAll(GetLines(ReadFile(folder + cm.FileIn.get(i)), cm.numbn));
            }
        }
        if (cm.booo) {
            PrintOut(folder + cm.FileOut, listf);
        } else {
            for (int i = 0; i < listf.size(); i++)
                System.out.println(listf.get(i));
        }
    }

    @Override
    public String toString() {
        String string = "";

        for (int i = 0; i < listf.size() - 1; i++) {
            string += listf.get(i) + "\n";
        }
        return string + listf.get(listf.size() - 1);
    }
}



