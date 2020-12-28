package dataStructuresPractice.linkedList;

public class ReverseLinkedList {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Node firstNode = new Node(10);
        Node secondNode = new Node(20);
        Node thirdNode = new Node(30);
        Node fourthNode = new Node(40);
        Node fifthNode = new Node(50);

        list.head = firstNode;
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
        fourthNode.next = fifthNode;
        list.printList(list.head);
        Node newHead = reverseLinkedList(list.head);
        list.printList(newHead);
    }

    private static Node reverseLinkedList(Node head) {
        Node n = head;
        Node p = head;
        Node prev = head;

        if (p == head) {
            p = p.next;
            n.next = null;
        }

        while (p != null) {
            Node current = p;
            p = p.next;
            current.next = prev;
            prev = current;
        }
        head = prev;
        return head;
    }

}

