package dataStructuresPractice.linkedList;

//same implementation as LinkedList, just non-static
public class LinkedListV2 {

    public Node head;

     void add(String data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;

    }

    //iterative
    public  int findLength() {
        int count = 0;
        Node n = head;
        while (n != null) {
            count++;
            n = n.next;
        }
        return count;
    }

    //recursive
    public  int getLength(Node head) {
        if (head == null) return 0;
        return 1 + getLength(head.next);
    }

    public  void printList(Node head) {
        Node n = head;
        while (n != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.print("null\n");
    }

    public  void printDataInList(Node head) {
        Node n = head;
        while (n != null) {
            System.out.print(n.input + " -> ");
            n = n.next;
        }
        System.out.print("null\n");
    }

    public  boolean search(int data) {
        Node n = head;
        while (n != null) {
            if (n.data == data) return true;
            else n = n.next;
        }
        return false;
    }

    public  boolean searchRecursively(Node head, int data) {

        if (head == null) return false;
        if (head.data == data) return true;
        else {
            return searchRecursively(head.next, data);
        }
    }

    public  int getNthNode(LinkedListV2 list, int index){
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

    public  int getNthNode2(LinkedListV2 list, int index){
        Node n = list.head;
        while(index > 0){
            if(n == null) return -1;
            n = n.next;
            index--;
        }

        return n.data;
    }


    public  int getNthNodeFromLast(int index){
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

    public int getMiddleNode(){
        Node slowPointer = head;
        Node fastPointer = head;
        while(fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer.data;
    }
    
}
