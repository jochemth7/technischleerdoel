import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.javacc.parser.ParseException;

public class Main {
    public static void main(String[] args) {
        String input = "als productvoorraad minder dan 50 dan bestel 10.";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        MyParser parser = new MyParser(inputStream);

        System.out.println("Main method started");
        System.out.println("Starting parser...");
        try {
            Node result = parser.sbvrRuleList();
            System.out.println("Parsing completed successfully!");
            printTree(result, 0);
        } catch (ParseException e) {
            System.err.println("Parsing failed: " + e.getMessage());
            e.printStackTrace();
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