package dataStructuresPractice.hashTable.hashmap;

public class HashNode<K, V> {

    K key;
    V value;
    final int hashcode;
    HashNode<K, V> next;

    public HashNode(K key, V value, final int hashcode){
        this.key = key;
        this.value = value;
        this.hashcode = hashcode;
        this.next = null;
    }

}
