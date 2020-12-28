package dataStructuresPractice.linkedList.mustDo;

import dataStructuresPractice.linkedList.LinkedList;
import dataStructuresPractice.linkedList.Node;

public class FindMiddleNode {
    static Node head;
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
        findMiddleNode(list.head);
    }

    private static void findMiddleNode(Node head) {
        LinkedList.printList(head);
        Node slowPointer = head;
        Node fastPointer = head;
        Node mid = null;
        while (fastPointer.next != null && fastPointer.next.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            mid = slowPointer;
        }

        if (fastPointer.next == null)
            System.out.println("Middle Node is -> " + mid.data);
        else
            if (fastPointer.next.next == null)
            System.out.println("Middle Node is -> " + mid.next.data);

    }
}
