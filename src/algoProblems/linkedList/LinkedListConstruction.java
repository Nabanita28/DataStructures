package algoProblems.linkedList;

public class LinkedListConstruction {

    class MyLinkedList {

         Node head;

        class Node{
            Node next;
            int val;

            public Node(int val){
                this.val = val;
                this.next = null;
            }
        }

        /** Initialize your data structure here. */
        public MyLinkedList() {

            this.head = null;
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */

        public int getLength(){
            Node current = head;
            int length = 0;
            while(current != null){
                current = current.next;
                length++;
            }
            return length;
        }

        public int get(int index) {
            Node current = head;

            if(head == null)
                return -1;

            if(index <= getLength()){

                while(index > 0){
                    current = current.next;
                    index--;
                }
                return current.val;
            }
            return -1;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {

            if(head == null){
                head = new Node(val);
            }else{
                Node node = new Node(val);
                node.next = head;
                head = node;
            }
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            Node node = new Node(val);
            current.next = node;
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            Node current = head;
            Node prev = head;
            while(index > 0){
                prev = current;
                current = current.next;
                index--;
            }
            Node node = new Node(val);
            prev.next = node;
            node.next = current;
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            Node current = head;
            Node prev = head;
            while(index > 0){
                prev = current;
                current = current.next;
                index--;
            }
            prev.next = current.next;
            current.next = null;
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
}
