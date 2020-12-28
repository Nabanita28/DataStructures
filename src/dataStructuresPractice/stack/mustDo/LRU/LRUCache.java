package dataStructuresPractice.stack.mustDo.LRU;


import java.util.HashMap;
import java.util.Map;
//TODO - revisit
public class LRUCache {

    int capacity;
    int count;
    Node head;
    Node tail;
    static Map<Integer, Node> map;

    public LRUCache(int capacity){
        map = new HashMap<>();
        this.capacity = capacity;
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        head.prev = null;
        tail.prev = head;
        tail.next = null;
        count = 0;
    }

    private void deleteNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addNodeToHead(Node node){
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    public void set(int key, int value){
        if (map.containsKey(key)){
           Node node = map.get(key);
           node.value = value;
           deleteNode(node);
           addNodeToHead(node);
        }
        else {
            Node node = new Node(key, value);
            map.put(key, node);
            if (capacity > count){
                count++;
                addNodeToHead(node);
            }
            else{
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
                addNodeToHead(node);
            }
        }
    }

    public int get(int key){
        if (map.containsKey(key)){
            Node node = map.get(key);
            deleteNode(node);
            addNodeToHead(node);
            return node.value;
        }
        return -1;
    }
}
