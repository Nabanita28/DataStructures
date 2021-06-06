package dataStructuresPractice.linkedList;

public class SortAscending {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Node firstNode = new Node(2);
        Node secondNode = new Node(4);
        Node thirdNode = new Node(6);
        Node fourthNode = new Node(7);
        Node fifthNode = new Node(5);
        Node sixthNode = new Node(1);

        list.head = firstNode;
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
        fourthNode.next = fifthNode;
        fifthNode.next = sixthNode;

        LinkedList.printList(list.head);
        Node newHead = sortList(list.head);
        LinkedList.printList(newHead);
    }
    public static Node sortList(Node head) {
        //base case
        if(head == null || head.next == null){
            return head;
        }

        Node mid = getMid(head);
        Node left = sortList(head);
        Node right = sortList(mid);
        return merge(left, right);
    }

    static Node getMid(Node node){
        Node slowPointer = node;
        Node fastPointer = node;
        Node prevPointer = slowPointer;
            while(fastPointer.next != null && fastPointer.next.next != null){
                prevPointer = slowPointer;
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next.next;
        }


        prevPointer.next = null;
        return slowPointer;
    }

    static Node merge(Node left, Node right){

        Node currentHead = new Node(0);
        Node tail = currentHead;

        while(left != null && right != null){
            if(left.data < right.data){
                tail.next = left;
                left = left.next;
                tail = tail.next;
            }else{
                tail.next = right;
                right = right.next;
                tail = tail.next;
            }
        }

        tail.next = left.next != null ? left : right;
        return currentHead.next;
    }
}
