package dataStructuresPractice.linkedList;

public class Node {
    public int data;
    public String input;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public Node(String input) {
        this.input = input;
        this.next = null;
    }

    public Node() {
    }
}
