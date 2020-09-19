package linkedList.mustDo;

import linkedList.LinkedList;
import linkedList.Node;

public class ReverseKNodes {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Node firstNode = new Node(2);
        Node secondNode = new Node(4);
        Node thirdNode = new Node(6);
        Node fourthNode = new Node(7);
        Node fifthNode = new Node(5);
        Node sixthNode = new Node(1);

        list.head = firstNode;
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
        fourthNode.next = fifthNode;
        fifthNode.next = sixthNode;

        LinkedList.printList(list.head);
        Node latestHead = reverse(list.head, 4);
        LinkedList.printList(latestHead);
    }

    private static Node reverse(Node head, int k) {

        Node current = head;
        Node prev = null;
        Node next = null;
        int count = 0;

        while (count < k && current != null) {

            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;

        }

        if (next != null) {
            head.next = reverse(next, k);
        }

        return prev;
    }
}
