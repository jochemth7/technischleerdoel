import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws ParseException {
        System.out.println("Main method started");

        String input = "123 + 456"; // Predefined input
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        MyParser parser = new MyParser(inputStream);

        try {
            System.out.println("Starting parser...");
            parser.Start(); // Parse the input
            System.out.println("Parsing completed!");
        } catch (ParseException e) {
            System.out.println("Parsing failed: " + e.getMessage());
        }
    }
}
