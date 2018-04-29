import org.junit.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import static java.lang.Math.max;
import static org.junit.Assert.assertTrue;

public class TTest {

    @Test
    public void tail() {
        ArrayList<String[]> list = new ArrayList<>();
        list.add("-c 5 -o out.txt ES.txt Storm.txt".split(" "));
        list.add("-n 2 -o out.txt ES.txt Storm.txt".split(" "));
        list.add("-o out.txt ES.txt Storm.txt".split(" "));
        list.add("-n 2 ES.txt Storm.txt".split(" "));
        ArrayList<String> results = new ArrayList<>();
        results.add(" 4 1.\n" +
                "mple."
        );
        results.add("8 9 1 2 3 4 6.\n" +
                "7 8 9 6 5 4 1.\n" +
                "Play Target sound plays on the target upon cast.\n" +
                "Play Full sound example."
        );

        results.add(
                "ES\n" +
                        "1 2 3 4 5 6 7.\n" +
                        "8 9 1 2 3 4 6.\n" +
                        "7 8 9 6 5 4 1.\n" +
                        "Static Remnant\n" +
                        "Play Cast sound plays on Storm Spirit upon cast.\n" +
                        "Play Target sound plays whenever a Static Remnant explodes, be it by getting triggered or by expiring (70% vol).\n" +
                        "Electric Vortex\n" +
                        "Play Cast sound plays on Storm Spirit upon cast.\n" +
                        "Play Target sound plays on the target upon cast.\n" +
                        "Play Full sound example."
        );

        results.add("8 9 1 2 3 4 6.\n" +
                "7 8 9 6 5 4 1.\n" +
                "Play Target sound plays on the target upon cast.\n" +
                "Play Full sound example."
        );
        for (int i = 0; i < list.size() - 1; i++) {
            boolean t = true;
            try {
                Tail tail = new Tail(list.get(i));
                CommandCheck cmd = new CommandCheck(list.get(i));
                ArrayList ListTest = new ArrayList<>();
                if (cmd.isBooleanO()) {
                    BufferedReader out = new BufferedReader(new FileReader(cmd.getFileOut()));
                    String line;
                    while ((line = out.readLine()) != null) {
                        ListTest.add(line);
                    }
                } else ListTest = new Tail(list.get(i)).GetListf();
                String[] a = results.get(i).split("\n");
                for (int j = 0; j < max(ListTest.size(), a.length); j++) {
                    if (!ListTest.get(j).equals(a[j])) {
                        t = false;
                        break;
                    }
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            assertTrue(t);
        }
    }
}
