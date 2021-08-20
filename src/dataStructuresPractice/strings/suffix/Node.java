package dataStructuresPractice.strings.suffix;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private String text;
    List<Node> children;
    private int position;

    public Node(String text, int position){
        this.text = text;
        this.position = position;
        this.children = new ArrayList<>();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Node{" +
                "text='" + text + '\'' +
                ", children=" + children +
                ", position=" + position +
                '}';
    }
}
