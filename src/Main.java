public class Main {
    public static void main(String[] args) {
        try {
            Tail tail = new Tail("-o out.txt ES.txt Stormvoice.txt");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}