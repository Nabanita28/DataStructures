package linkedList;

public class Node {
    int data;
    String input;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public Node(String input) {
        this.input = input;
        this.next = null;
    }
}
