package dataStructuresPractice.inPlaceReversal;

import dataStructuresPractice.linkedList.Node;

public class ReverseBetweenLeftAndRight {
    public static void main(String[] args) {
        Node firstNode = new Node(3);
        Node secondNode = new Node(5);
        //Node thirdNode = new Node(7);
        /*Node fourthNode = new Node(4);
        Node fifthNode = new Node(5);
        Node sixthNode = new Node(6);
*/
        Node head = firstNode;
        firstNode.next = secondNode;
     //   secondNode.next = thirdNode;
       /* thirdNode.next = fourthNode;
        fourthNode.next = fifthNode;
        fifthNode.next = sixthNode;
*/
        Node newHead = reverseBetween(head, 1, 2);
        while (newHead != null){
            System.out.print(newHead.data + " ");
            newHead = newHead.next;
        }
    }

    public static Node reverseBetween(Node head, int left, int right) {

        if(head == null){
            return null;
        }

        Node previous = null;
        Node curr = head;

        while(left > 1){
            previous = curr;
            curr = curr.next;
            left--;
            right--;
        }

        Node lastNodeOfFirstPart = previous;
        Node lastNodeOfSubList = curr;
        Node third = null;

        while(right > 0){
            third = curr.next;
            curr.next = previous;
            previous = curr;
            curr = third;
            right--;
        }

        if(lastNodeOfFirstPart != null){
            lastNodeOfFirstPart.next = previous;
        } else{
            head = previous;
        }
        lastNodeOfSubList.next = curr;

        return head;

    }
}
