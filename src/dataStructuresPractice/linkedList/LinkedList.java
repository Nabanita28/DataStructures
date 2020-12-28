package dataStructuresPractice.linkedList;

public class LinkedList {

    public static Node head;

    static void add(String data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;

    }

    //iterative
    public static int findLength() {
        int count = 0;
        Node n = head;
        while (n != null) {
            count++;
            n = n.next;
        }
        return count;
    }

    //recursive
    public static int getLength(Node head) {
        if (head == null) return 0;
        return 1 + getLength(head.next);
    }

    public static void printList(Node head) {
        Node n = head;
        while (n != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.print("null\n");
    }

    public static void printDataInList(Node head) {
        Node n = head;
        while (n != null) {
            System.out.print(n.input + " -> ");
            n = n.next;
        }
        System.out.print("null\n");
    }

    public static boolean search(int data) {
        Node n = head;
        while (n != null) {
            if (n.data == data) return true;
            else n = n.next;
        }
        return false;
    }

    public static boolean searchRecursively(Node head, int data) {

        if (head == null) return false;
        if (head.data == data) return true;
        else {
            return searchRecursively(head.next, data);
        }
    }

    public static int getNthNode(LinkedList list, int index){
        Node current = head;
        int count = 0;
        if(head == null) return 0;
        if(!(index > getLength(list.head))){
        while(count != index ){
            current = current.next;
            count++;
        }
        return current.data;
    }
        return -1;
    }

    public static int getNthNode2(LinkedList list, int index){
        Node n = list.head;
        while(index > 0){
            if(n == null) return -1;
            n = n.next;
            index--;
        }

        return n.data;
    }


    public static int getNthNodeFromLast(int index){
        Node slowPointer = head;
        Node fastPointer = head;
        int newIndex = index;
        // advance fastPointer by index
        while(newIndex > 0){
            fastPointer = fastPointer.next;
            newIndex--;
        }
        //moving both pointers ahead
        while(fastPointer != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }
        return slowPointer.data;
    }

    public static int getMiddleNode(){
        Node slowPointer = head;
        Node fastPointer = head;
        while(fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer.data;
    }



    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Node firstNode = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);
        Node fourthNode = new Node(4);
        Node fifthNode = new Node(5);

        list.head = firstNode;
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
        fourthNode.next = fifthNode;
        /*list.add(6);
        list.add(7);*/


        printList(head);
        //System.out.println("Length of list : " + findLength(list));
        System.out.println("Length of list : " + getLength(list.head));
        System.out.println(search(99));
        System.out.println(searchRecursively(head, 2));
        System.out.println(getNthNode2(list, 1));
        System.out.println("Middle node : " + getMiddleNode());
        System.out.println("Get Nth node from last : " + getNthNodeFromLast(2));
    }
}
