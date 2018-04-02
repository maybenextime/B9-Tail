import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class TTest {

    @Test
    public void tail() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("tail -c 5 -o out.txt ES.txt Storm.txt");
        list.add("tail -n 2 -o out.txt ES.txt Storm.txt");
        list.add("tail -o out.txt ES.txt Storm.txt");
        list.add("tail -n 2 ES.txt Storm.txt");
        ArrayList<String> results = new ArrayList<String>();
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
        for (int i = 0; i < list.size(); i++) {
            try {
                Assert.assertEquals(results.get(i), new Tail(list.get(i)).toString());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
