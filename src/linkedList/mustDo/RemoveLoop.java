package linkedList.mustDo;

import linkedList.LinkedList;
import linkedList.Node;

public class RemoveLoop {
    static  Node head;
    public static void main(String[] args) {
        Node firstNode = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);
        Node fourthNode = new Node(4);
        Node fifthNode = new Node(5);
        Node sixthNode = new Node(6);

        head = firstNode;
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
        fourthNode.next = fifthNode;
        fifthNode.next = sixthNode;
        sixthNode.next = thirdNode;
        removeLoop();
    }


    private static void removeLoop(){
        Node slowPointer = head;
        Node fastPointer = head;

        while(fastPointer.next != null && fastPointer.next.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if (slowPointer == fastPointer) {
                System.out.println("Loop detected");
                slowPointer = head;
                break;
            }
        }
        while (slowPointer.next != fastPointer.next){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }

        fastPointer.next = null;
            LinkedList.printList(head);
        }
    }
