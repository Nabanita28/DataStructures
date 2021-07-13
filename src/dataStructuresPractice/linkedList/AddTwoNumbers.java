package dataStructuresPractice.linkedList;

public class AddTwoNumbers {

    public static void main(String[] args) {
        Node firstNode = new Node(9);
        Node secondNode = new Node(9);
        Node thirdNode = new Node(9);
        Node head1 = firstNode;
        firstNode.next = secondNode;
        secondNode.next = thirdNode;

        Node fourthNode = new Node(9);
        Node fifthNode = new Node(9);
      //  Node sixthNode = new Node(4);
        Node head2 = fourthNode;
        fourthNode.next = fifthNode;
     //   fifthNode.next = sixthNode;

        Node newHead = addTwoNumbers(head1, head2);

        while(newHead != null){
            System.out.println(newHead.data);
            newHead = newHead.next;
        }
    }
    public static Node addTwoNumbers(Node l1, Node l2) {
        Node first = l1;
        Node second = l2;
        Node temp = null;
        Node prev = null;
        int carry = 0;
        Node newHead = null;
        while(first != null || second != null){

            int sum = (first != null ? first.data : 0) + (second != null ? second.data : 0) + carry;
            int val = sum % 10;
            carry = sum / 10;
            temp = new Node(val);
            if(prev == null){
                prev = temp;
                newHead = prev;
            }else{
                prev.next = temp;
                prev = temp;
            }
            if(first != null)
                first = first.next;
            if(second != null){
                second = second.next;
            }
        }
        if(carry > 0){
            temp = new Node(carry);
            prev.next = temp;
        }
        return newHead;
    }
}
