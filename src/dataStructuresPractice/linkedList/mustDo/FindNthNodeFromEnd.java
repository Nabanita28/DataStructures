package dataStructuresPractice.linkedList.mustDo;

import dataStructuresPractice.linkedList.Node;

public class FindNthNodeFromEnd {
    static Node head;
    public static void main(String[] args) {
        Node firstNode = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);
        Node fourthNode = new Node(4);
        Node fifthNode = new Node(5);
        Node sixthNode = new Node(6);

        head = firstNode;
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
        fourthNode.next = fifthNode;
        fifthNode.next = sixthNode;

        System.out.println(findNthNodeFromEnd(head, 3));

    }

    private static int findNthNodeFromEnd(Node head, int k) {
        Node slowPointer = head;
        Node fastPointer = head;

        while (k != 0){
            fastPointer = fastPointer.next;
            k--;
        }

        while(fastPointer != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }

        return slowPointer.data;
    }
}
