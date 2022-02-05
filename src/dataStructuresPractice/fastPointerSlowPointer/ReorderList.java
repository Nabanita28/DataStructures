package dataStructuresPractice.fastPointerSlowPointer;

import dataStructuresPractice.linkedList.Node;

public class ReorderList {
    public static void main(String[] args) {
        Node firstNode = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);
        Node fourthNode = new Node(4);
        Node head = firstNode;
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
        reorderList(head);
        while(head != null){
            System.out.print(head.data + "-> ");
        }
    }

    public static void reorderList(Node head) {

        Node slowPointer = head;
        Node fastPointer = head;

        while(fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        Node middle = reverse(slowPointer);
        Node midTemp = slowPointer;
        Node curr = head;
        Node prev = head;

        while(midTemp != null){
            curr = curr.next;
            midTemp = middle.next;
            prev.next = middle;
            middle.next = curr;
            middle = midTemp;
            System.out.println("prev key before " + prev.data);
            prev = curr;
            System.out.println("prev key after " + prev.data);
        }


        System.out.println("prev key final " + prev.data);

        if(prev != null){
            prev.next = null;
        }

    }

    static Node reverse(Node node){
        Node curr = node;
        Node prev = node;
        Node temp = null;

        while(curr != null){
            curr = curr.next;
            prev.next = temp;
            temp = prev;
            prev = curr;
        }
        return temp;
    }
}
