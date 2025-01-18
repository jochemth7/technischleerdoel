// Node.java
import java.util.ArrayList;
import java.util.List;

public class Node {
    private String name;
    private String type;
    private String word;
    private List<Node> children = new ArrayList<>();

    public Node(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void addChild(Node child) {
        children.add(child);
    }

    public List<Node> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return name + (word != null ? " (" + word + ")" : "");
    }
}