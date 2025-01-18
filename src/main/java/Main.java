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
            Node result = parser.Start(); // Parse the input
            System.out.println("Parsing completed!");
            printTree(result, 0); // Print the parse tree
        } catch (ParseException e) {
            System.out.println("Parsing failed: " + e.getMessage());
        }
    }

    private static void printTree(Node node, int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
        System.out.println(node);
        for (Node child : node.getChildren()) {
            printTree(child, level + 1);
        }
    }
}