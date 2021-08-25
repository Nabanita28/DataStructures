package dataStructuresPractice.linkedList;

import static dataStructuresPractice.linkedList.LinkedList.printList;

public class SwapNodes {
    public static void main(String[] args) {

        Node firstNode = new Node(10);
        Node secondNode = new Node(20);
        Node thirdNode = new Node(30);
        Node fourthNode = new Node(40);
        Node fifthNode = new Node(50);

        Node head = firstNode;
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
        fourthNode.next = fifthNode;


      /*  swapNodes(list.head, 20, 50);
        list.printList(list.head);
*/
        swapPairs(head);
        System.out.println("Pair wise swap : ");
        printList(head);

    }

    private static void swapNodes(Node head, int x, int y) {
        Node n = head;
        Node p1 = head;
        Node p2 = head;
        while (p1.next != null && p1.next.data != x) {
            p1 = p1.next;
        }
        Node temp1 = p1.next;
        while (p2.next != null && p2.next.data != y) {
            p2 = p2.next;
        }
        Node temp2 = p2.next;

        //SWAP
        p1.next = temp2;
        p2.next = temp1;

        Node temp = temp1.next;
        temp1.next = temp2.next;
        temp2.next = temp;


    }

    public static Node swapPairs(Node head) {
        Node temp;

        //base case
        if (head == null || head.next == null) {
            return head;
        } else {
            temp = head.next;
            head.next = temp.next;
            temp.next = head;
            head = temp;
            head.next.next = swapPairs(head.next.next);
            return head;
        }
    }

}
