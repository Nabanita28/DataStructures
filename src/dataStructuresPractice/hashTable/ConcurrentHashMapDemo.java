package dataStructuresPractice.hashTable;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(1, 2);
        ArrayList arrayList = new ArrayList();
        arrayList.add("aa");
        arrayList.add("bb");
        arrayList.add(12);
        System.out.println((String) arrayList.get(2));
    }
}
