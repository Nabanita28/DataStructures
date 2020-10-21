package linkedList.mock.interviews;

import linkedList.Node;

public class TraverseMNodesAndDeleteNNodes {
    public static void main(String[] args) {
        Node firstNode = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);
        Node fourthNode = new Node(4);
        Node fifthNode = new Node(5);
        Node sixthNode = new Node(6);
        Node seventhNode = new Node(7);
        Node eighthNode = new Node(8);
        Node ninthNode = new Node(9);
        Node tenthNode = new Node(10);
        Node head = firstNode;
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
        fourthNode.next = fifthNode;
        fifthNode.next = sixthNode;
        sixthNode.next = seventhNode;
        seventhNode.next = eighthNode;
        eighthNode.next = ninthNode;
        ninthNode.next = tenthNode;

        traverseMNodesAndDeleteNNodes(head, 2, 2);
    }

    private static void traverseMNodesAndDeleteNNodes(Node head, int m, int n) {

        Node prev = head;
        Node current = head;

        while(current != null){
            int mCount = 0;
            while(mCount < m && current != null){
                prev = current;
                current = current.next;
                mCount++;
            }

            int nCount = 0;
            while(nCount < n && current != null){
                current = current.next;
                nCount++;
            }
                prev.next = current;
        }

        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
