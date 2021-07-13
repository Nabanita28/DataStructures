package dataStructuresPractice.stack.mustDo.LRU;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class LRUCacheVersion2 {
    LinkedHashSet<Integer> cache;
    int capacity;

    public LRUCacheVersion2(int capacity){
        this.capacity = capacity;
        this.cache = new LinkedHashSet<>();
    }

    boolean get(int key){
        if(!cache.contains(key)){
            return false;
        }
        cache.remove(key);
        cache.add(key);
        return true;
    }

    void put(int key){
        if(cache.size() == capacity){
            int firstKey = cache.iterator().next();
            cache.remove(firstKey);
            cache.add(key);
        }
        cache.add(key);
    }

    void refer(int key){
        if(!get(key)){
            put(key);
        }
        cache.remove(key);
        cache.add(key);
    }

    void display(){
        LinkedList<Integer>  list = new LinkedList<>(cache);
        Iterator<Integer> itr = list.descendingIterator();
        while(itr.hasNext()){
            System.out.print(itr.next() + " ");
        }
    }

    public static void main(String[] args) {
        LRUCacheVersion2 lruCacheVersion2 = new LRUCacheVersion2(4);
        lruCacheVersion2.refer(1);
        lruCacheVersion2.refer(2);
        lruCacheVersion2.refer(3);
        lruCacheVersion2.refer(1);
        lruCacheVersion2.refer(4);
        lruCacheVersion2.refer(5);
        lruCacheVersion2.display();
    }
}
