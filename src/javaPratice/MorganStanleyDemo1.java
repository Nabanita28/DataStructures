package javaPratice;

public class MorganStanleyDemo1 {
    public static void main(String[] args) {
        Node firstNode  = new Node(1);
        Node secNode  = new Node(2);
        /*Node thirdNode  = new Node(3);
        Node fourthNode  = new Node(4);
        Node fifthNode  = new Node(5);
        Node sixthNode  = new Node(6);
        Node seventhNode  = new Node(7);
        Node eighthNode  = new Node(11);
        Node ninthNode  = new Node(9);
        Node tenthNode  = new Node(0);*/
        Node  head = firstNode;
        firstNode.next = secNode;
        /*secNode.next = thirdNode;
        thirdNode.next = fourthNode;
        fourthNode.next = fifthNode;
        fifthNode.next = sixthNode;
        sixthNode.next = seventhNode;
        seventhNode.next = eighthNode;
        eighthNode.next = ninthNode;
        ninthNode.next = tenthNode;*/
        System.out.println(findThirdElementFromLast(head));
    }

    //3rd last element in the linked list
    public static int findThirdElementFromLast(Node head){

        Node slowPointer = head;
        Node fastPointer = head;
        int k = 3;
        while(k > 0 && fastPointer != null){
            fastPointer = fastPointer.next;
            k--;
        }

        while(fastPointer != null ){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }
        return slowPointer.val;
    }

    public static class Node{
        int val;
        Node next;

        public Node(int val){
            this.val = val;
            this.next = null;
        }
    }
}
