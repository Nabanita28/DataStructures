package dataStructuresPractice.linkedList.mustDo;

import dataStructuresPractice.linkedList.LinkedList;
import dataStructuresPractice.linkedList.Node;

public class ReverseAlternateKNodes {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Node firstNode = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);
        Node  fourthNode = new Node(4);
        Node  fifthNode = new Node(5);
        Node sixthNode  = new Node(6);
        Node  seventhNode = new Node(7);
        Node eighthNode = new Node(8);
        Node ninthNode = new Node(9);

        list.head = firstNode;
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
        fourthNode.next = fifthNode;
        fifthNode.next = sixthNode;
        sixthNode.next = seventhNode;
        seventhNode.next = eighthNode;
        eighthNode.next = ninthNode;


        LinkedList.printList(list.head);
        Node latestHead = reverseAlternateKNodes(list.head, 3);
        LinkedList.printList(latestHead);
    }
    public static Node reverseAlternateKNodes(Node A, int B) {


        Node current = A;
        Node prev = null;
        Node next = null;


        int count = 0;
        while(current != null && count < B){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        if(A != null){
            A.next = current;
        }

        count = 0;
        while(count < B-1 && current != null){
            current = current.next;
            count++;
        }
        if(current != null){
            current.next = reverseAlternateKNodes(current.next, B);
        }


        return prev;
    }
}
