package algoProblems.linkedList;

import dataStructuresPractice.linkedList.Node;

public class RemoveKthNodeFromEnd {
    public static void main(String[] args) {
        Node firstNode = new Node(10);
        Node secondNode = new Node(20);
        Node thirdNode = new Node(30);
        Node fourthNode = new Node(40);
        Node fifthNode = new Node(50);
        Node sixthNode = new Node(60);
        Node seventhNode = new Node(70);
        Node head = firstNode;
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
        fourthNode.next = fifthNode;
        fifthNode.next = sixthNode;
        sixthNode.next = seventhNode;
        printLinkedList(head);
        System.out.println();
        removeKthNodeFromEnd(head, 5);
        printLinkedList(head);
    }

    private static void printLinkedList(Node head) {
        while(head != null){
            System.out.print(head.data + "->");
            head = head.next;
        }
    }

    private static void removeKthNodeFromEnd(Node head, int k) {

        Node prev = head;
        Node slowPointer = head;
        Node fastPointer = head;
        int counter = k;
        while(counter > 0){
            fastPointer = fastPointer.next;
            counter--;
        }

        while(fastPointer != null){
            prev = slowPointer;
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }

        prev.next = slowPointer.next;
        slowPointer.next = null;
    }
}
