package dataStructuresPractice.linkedList;

import java.util.Stack;

public class LinkedListPalindrome {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        Node firstNode = new Node("m");
        Node secondNode = new Node("a");
        Node thirdNode = new Node("d");
        Node fourthNode = new Node("a");
        Node fifthNode = new Node("m");
        list.head = firstNode;
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
        fourthNode.next = fifthNode;
        list.printDataInList(list.head);
        System.out.println(isPalindrome(list.head));
        System.out.println(isLinkedListPalindrome(list.head));
    }

    public static boolean isPalindrome(Node head) {
        Node n = head;
        boolean result = true;
        Stack<String> stack = new Stack();
        while (n != null) {
            stack.push(n.input);
            n = n.next;
        }
        n = head;
        while (n != null) {
            if (n.input.equalsIgnoreCase(stack.pop())) {
                result = true;
                n = n.next;
            } else {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean isLinkedListPalindrome(Node head) {
        Node fp = head;
        Node sp = head;

        while (fp.next != null && fp.next.next != null) {
            sp = sp.next;
            fp = fp.next.next;
        }
        //reverse second half
        Node head2 = reverseLinkedList(sp.next);
        sp.next = null;
        Node head1 = head;

        while (head1 != null && head2 != null) {
            if (head1.input != head2.input) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
    }

    static Node reverseLinkedList(Node node) {
        Node current = node;
        Node prev = null;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}