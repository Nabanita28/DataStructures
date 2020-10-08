package linkedList.mustDo;

import linkedList.LinkedList;
import linkedList.Node;

public class ReverseLinkedList {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Node firstNode = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);

        list.head = firstNode;
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        list.printList(list.head);
        reverseLinkedList(list.head);
    }

    private static void reverseLinkedList(Node head) {


    }
}
