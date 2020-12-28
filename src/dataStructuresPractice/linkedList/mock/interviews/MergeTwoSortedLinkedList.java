package dataStructuresPractice.linkedList.mock.interviews;

import dataStructuresPractice.linkedList.LinkedList;
import dataStructuresPractice.linkedList.Node;

public class MergeTwoSortedLinkedList {

    public static void main(String[] args) {
        Node zero = new Node(0);
        Node two = new Node(2);
        Node four = new Node(4);
        Node head1 = zero;
        zero.next = two;
        two.next = four;

        Node one = new Node(1);
        Node three = new Node(3);
        Node five = new Node(5);
        Node head2 = one;
        one.next = three;
        three.next = five;

        System.out.println("head1");
        LinkedList.printList(head1);

        System.out.println("head    2");
        LinkedList.printList(head2);

        System.out.println("After merging two linked list: ");

        Node node = mergeTwoSortedLinkedList(head1, head2);
        while(node != null){
            System.out.print(node.data);
            node = node.next;
        }
    }

    private static Node mergeTwoSortedLinkedList(Node head1, Node head2) {

        Node current1 = head1;
        Node postCurrent1 = head1.next;

        Node current2 = head2;
        Node postCurrent2 = head2.next;

        while(postCurrent1 != null && current2 != null) {
            if (current2.data >= current1.data && current2.data <= postCurrent1.data) {

                current1.next = current2;
                current2.next = postCurrent1;
                current1 = postCurrent1;
                current2 = postCurrent2;

            } else if (postCurrent1.next != null) {

                current1 = current1.next;
                postCurrent1 = postCurrent1.next;

            } else {
                postCurrent1.next = current2;
                return head1;
            }
        }
            return head1;
    }
}
