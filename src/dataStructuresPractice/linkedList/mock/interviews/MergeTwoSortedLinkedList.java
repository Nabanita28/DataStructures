package dataStructuresPractice.linkedList.mock.interviews;

import dataStructuresPractice.linkedList.LinkedList;
import dataStructuresPractice.linkedList.Node;

public class MergeTwoSortedLinkedList {

    public static void main(String[] args) {
        Node zero = new Node(1);
        Node two = new Node(2);
        Node four = new Node(4);
        Node head1 = zero;
        zero.next = two;
        two.next = four;

        Node one = new Node(1);
        Node three = new Node(3);
        Node five = new Node(4);
        Node head2 = one;
        one.next = three;
        three.next = five;

        System.out.println("head1");
        LinkedList.printList(head1);

        System.out.println("head    2");
        LinkedList.printList(head2);

        System.out.println("After merging two linked list: ");

        Node node = mergeTwoSortedLinkedList(head1, head2);
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
    }

    private static Node mergeTwoSortedLinkedList(Node head1, Node head2) {
//time complexity - O(n+m)
        Node head = new Node();
        Node tail = head;

        while (true) {
            if (head1 == null) {
                tail.next = head2;
                break;
            }

            if (head2 == null) {
                tail.next = head1;
                break;
            }

            if (head1.data <= head2.data) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        return head.next;
    }

}
