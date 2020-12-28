package dataStructuresPractice.stack.mustDo.LRU;

public class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }
}
