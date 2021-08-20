package dataStructuresPractice.hashTable.hashmap;

import java.util.ArrayList;

public class Map<K, V> {

    ArrayList<HashNode<K, V>> buckets;
    int bucketSize;
    int size;

    public Map() {
        this.buckets = new ArrayList<>();
        this.bucketSize = 10;
        this.size = 0;

        for (int i = 0; i < bucketSize; i++) {
            buckets.add(null);
        }
    }

    private int hashcode(K key) {
        return key.hashCode();
    }

    private int getBucketIndex(K key) {
        int index = hashcode(key) % bucketSize;
        //hashcode can be negative
        return index < 0 ? index * (-1) : index;
    }

    private int size(){
        return size;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    public V get(K key) {
        int hashcode = hashcode(key);
        int bucketIndex = getBucketIndex(key);

        HashNode<K, V> head = buckets.get(bucketIndex);

        while (head != null) {
            if (hashcode == key.hashCode() && head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public V remove(K key) {
        int hashcode = hashcode(key);
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = buckets.get(bucketIndex);

        HashNode<K, V> prev = null;

        while (head != null) {
            if (head.hashcode == hashcode && head.key.equals(key)) {
                break;
            }
            prev = head;
            head = head.next;
        }
        //if key is not found
        if (head == null) {
            return null;
        }


        if (prev != null) {
            prev.next = head.next;
        } else {
            //if head is the key
            buckets.set(bucketIndex, head.next);
        }
        size--;
        return head.value;
    }

    public void add(K key, V value){
        int hashcode = hashcode(key);
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = buckets.get(bucketIndex);

        while(head != null){
            if(head.hashcode == hashcode && head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;

        head = buckets.get(bucketIndex);
        HashNode<K, V> newNode = new HashNode<>(key, value, hashcode);
        newNode.next = head;
        buckets.set(bucketIndex, newNode);

        //check loadFactor
        if((1.0*size)/bucketSize > 0.7){
            ArrayList<HashNode<K, V>> temp = buckets;
            buckets = new ArrayList<>();
            bucketSize = bucketSize*2;
            size = 0;
            //initialize buckets with null
            for(int i=0; i<bucketSize; i++){
                buckets.add(null);
            }
            for(HashNode<K, V> node : temp){
                while(node != null){
                    add(node.key, node.value);
                    node = node.next;
                }
            }
        }
    }

    public static void main(String[] args){
        Map<String, Integer> map = new Map<>();
        map.add("Nabanita", 99);
        map.add("NabanitaAlways", 100);
        map.add("Rajeev", 3);
        map.add("Rajeev1", 3);
        map.add("Rajeev2", 3);
        map.add("Rajeev3", 3);
        map.add("RajeevBad", 3);
        map.add("RajeevCute", 3);
        map.add("RajeevNaughty", 3);
        map.add("Puchku", 3);
        map.add("Ranjan", 3);
        System.out.println("Current size of map is : " + map.size());
        System.out.println("Get Nabanita : " + map.get("Nabanita"));
        System.out.println("Removing Nabanita : " + map.remove("Nabanita"));
        System.out.println("Is map empty ? - " + map.isEmpty());
        System.out.println("Removing Rajeev : " + map.remove("Rajeev"));
        System.out.println("Current size of map after removing is : " + map.size());
        System.out.println("Is map empty ? - " + map.isEmpty());

    }
}
