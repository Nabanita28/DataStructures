package linkedList;

public class SwapNodes {
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
        thirdNode.next= fourthNode;
        fourthNode.next = fifthNode;

        list.printList(list.head);
      /*  swapNodes(list.head, 20, 50);
        list.printList(list.head);
*/
        pairWiseSwap(list);
        System.out.println("Pair wise swap : ");
        list.printList(list.head);

    }

    private static void swapNodes(Node head, int x, int y) {
        Node n  = head;
        Node p1 = head;
        Node p2 = head;
        while(p1.next != null && p1.next.data != x ){
            p1 = p1.next;
        }
        Node temp1 = p1.next;
        while(p2.next != null && p2.next.data != y ){
            p2 = p2.next;
        }
        Node temp2 = p2.next;

        //SWAP
       p1.next = temp2;
       p2.next = temp1;

       Node temp = temp1.next;
       temp1.next = temp2.next;
       temp2.next = temp;


    }

    public static void pairWiseSwap(LinkedList list){
        Node p = list.head;
        list.head = list.head.next;
        Node lastUsed = null;
        while(p != null && p.next != null){
            Node first = p;
            Node second = p.next;
            Node third = p.next.next;

            second.next = first;
            first.next = third;

            if(lastUsed != null)
                lastUsed.next = second;

            lastUsed = first;

            p = third;
        }
    }

}
