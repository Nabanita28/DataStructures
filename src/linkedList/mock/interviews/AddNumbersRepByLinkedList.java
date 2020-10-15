package linkedList.mock.interviews;

import linkedList.Node;

public class AddNumbersRepByLinkedList {
    public static void main(String[] args) {
        Node firstNode = new Node(5);
        Node secondNode = new Node(6);
        Node thirdNode = new Node(3);
        Node head1 = firstNode;
        firstNode.next = secondNode;
        secondNode.next = thirdNode;

        Node fourthNode = new Node(8);
        Node fifthNode = new Node(4);
        Node sixthNode = new Node(2);
        Node head2 = fourthNode;
        fourthNode.next = fifthNode;
        fifthNode.next = sixthNode;

        addTwoNumbersRepByLinkedList(head1, head2);
    }

    private static void addTwoNumbersRepByLinkedList(Node head1, Node head2) {

        Node first = head1;
        Node second = head2;
        Node result = null;
        Node prev = null;
        Node temp = null;
        int sum = 0;
        int carry = 0;

        while (first != null || second != null) {

            sum = carry + (first != null ? first.data : 0) + (second != null ? second.data : 0);
            carry = sum >= 10 ? 1 : 0;
            sum = sum % 10;


            temp = new Node(sum);

            if (result == null)
                result = temp;


            if (prev == null)
                prev = temp;
            else {
                prev.next = temp;
                prev = temp;
            }

            first = first.next;

            second = second.next;

        }

        while (result != null) {
            System.out.print(result.data);
            if (result.next != null)
                System.out.print("->");
            result = result.next;
        }
    }
}
