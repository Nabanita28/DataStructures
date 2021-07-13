package dataStructuresPractice.hashTable;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TopKFrequentCharacters {
    public static void main(String[] args) {
        String s  = "$geeksforGEEKs@@@@@@@";
       findTopKFrequentChars(s, 3);
    }

    private static void findTopKFrequentChars(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            if (!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), 1);
            }
            map.put(s.charAt(i), map.get(s.charAt(i))+1);
        }

        //sort the hashmap
        Map<Character, Integer> sortedMap = map.entrySet().stream()
                .sorted((i1, i2) -> i2.getValue().compareTo(i1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        for(Map.Entry entry : sortedMap.entrySet()){
            if(k==0) break;
            System.out.println(entry.getKey() + " -> " + entry.getValue());
            k--;
        }
    }
}
