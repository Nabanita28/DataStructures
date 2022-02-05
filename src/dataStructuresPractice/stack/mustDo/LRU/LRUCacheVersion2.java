package dataStructuresPractice.stack.mustDo.LRU;

import java.util.*;

public class LRUCacheVersion2 {
    LinkedHashMap<Integer, Integer> cache;
    int capacity;

    public LRUCacheVersion2(int capacity){
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity);
    }

    boolean get(int key){
        if(!cache.containsKey(key)){
            return false;
        }
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
        return true;
    }

    void put(int key, int val){
        if(cache.size() == capacity){
            if (cache.containsKey(key)){
                cache.remove(key);
            }else{
                cache.remove(cache.keySet().iterator().next());
            }
        }
        cache.put(key, val);
    }

    void display(){
        for(Map.Entry entry : cache.entrySet()){
            System.out.println("Key = " + entry.getKey() + " Value = " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        LRUCacheVersion2 lruCacheVersion2 = new LRUCacheVersion2(3);
        lruCacheVersion2.put(1, 100);
        lruCacheVersion2.put(2, 200);
        lruCacheVersion2.put(3, 300);
        lruCacheVersion2.get(1);
        lruCacheVersion2.get(2);
        lruCacheVersion2.put(1, 200);
        lruCacheVersion2.put(4, 400);
        lruCacheVersion2.put(5, 500);
        lruCacheVersion2.display();
    }
}
