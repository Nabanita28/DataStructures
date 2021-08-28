package dataStructuresPractice.linkedList.mustDo;

import dataStructuresPractice.linkedList.LinkedList;
import dataStructuresPractice.linkedList.Node;

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
        Node latestHead = reverseKGroup(list.head, 2);
        LinkedList.printList(latestHead);
    }
//time complexity - O(n), space complexity - O(n/k)
    private static Node reverseKGroup(Node head, int k) {

        Node current = head;
        int count = 0;

        while(count != k && current != null){
            current = current.next;
            count++;
        }
        //we found the k+1th node
        if(count == k){
            current = reverseKGroup(current, k);

            while(count-- > 0){
                Node temp = head.next;
                head.next = current;
                current = head;
                head = temp;
            }
            //pont head back to current
            head = current;
        }
        return head;
    }
}
