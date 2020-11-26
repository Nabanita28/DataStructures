package linkedList.mock.interviews;

import linkedList.Node;

public class IsLinkedListPalindrome {

    public static void main(String[] args) {
        Node firstNode = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(2);
        Node fourthNode = new Node(1);
        /*Node fifthNode = new Node(2);
        Node sixthNode = new Node(2);
        Node seventhNode = new Node(1);*/

        Node head = firstNode;
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
        /*fourthNode.next = fifthNode;
        fifthNode.next = sixthNode;
        sixthNode.next = seventhNode;*/

        System.out.println(isPalindrome(head));

    }

    public static boolean isPalindrome(Node head) {


        //find middle node
        Node originalHead = head;
        Node slowPointer = head;
        Node fastPointer = head;

        while(fastPointer.next != null && fastPointer.next.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        Node temp = slowPointer.next;

        slowPointer.next = null;
        Node tempHead = reverse(temp);

        while(originalHead != null && tempHead != null){

            if(originalHead.data == tempHead.data){
                originalHead = originalHead.next;
                tempHead = tempHead.next;
            } else{
                return false;
            }
        }
        return true;
    }

    public static Node reverse(Node node){

        Node curr = node;
        Node prev = null;
        Node nextNode = node;

        while(curr != null){

            nextNode = nextNode.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}
