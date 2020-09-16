package linkedList.mustDo;

import linkedList.LinkedList;
import linkedList.Node;

public class RotateLinkedList {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        Node firstNode = new Node(10);
        Node secondNode = new Node(20);
        Node thirdNode = new Node(30);
        Node fourthNode = new Node(40);
        Node fifthNode = new Node(50);
        Node sixthNode = new Node(60);
        Node seventhNode = new Node(70);
        linkedList.head = firstNode;
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
        fourthNode.next = fifthNode;
        fifthNode.next = sixthNode;
        sixthNode.next = seventhNode;
        LinkedList.printList(linkedList.head);
        rotateLinkedlist(linkedList.head, 4);
    }

    private static void rotateLinkedlist(Node head, int k) {
        int length = 0;
        Node current = head;
        Node temp = null;
        while(current.next != null){
            current = current.next;
            length++;
            if(length == k-1){
                temp = current;
            }
        }

        Node p = temp.next;
        temp.next = null;
        current.next = head;
        head = p;

        System.out.println();
        while(head.next != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
