import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.javacc.parser.ParseException;
import java.util.List;

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
            printTree(result, "", true);
        } catch (ParseException e) {
            System.err.println("Parsing failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void printTree(Node node, String prefix, boolean isTail) {
        System.out.println(prefix + (isTail ? "└── " : "├── ") + node);
        List<Node> children = node.getChildren();
        for (int i = 0; i < children.size() - 1; i++) {
            printTree(children.get(i), prefix + (isTail ? "    " : "│   "), false);
        }
        if (children.size() > 0) {
            printTree(children.get(children.size() - 1), prefix + (isTail ? "    " : "│   "), true);
        }
    }
}