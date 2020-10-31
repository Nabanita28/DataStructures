package hashTable;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public static void main(String[] args) {
        String[] magazine = {"two", "times", "three", "is", "not", "four"};
        String[] ransomNote = {"two", "times", "two", "is", "four"};
        checkMagazine(magazine, ransomNote);
    }

    static void checkMagazine(String[] magazine, String[] note) {


        Map<String, Integer> magazineMap = getFrequencies(magazine);
        Map<String, Integer> ransomNote = getFrequencies(note);

        compareFrequencies(magazineMap, ransomNote);
    }

    static void compareFrequencies(Map<String, Integer> magazineMap, Map<String, Integer> ransomNote){
        for(Map.Entry entry : ransomNote.entrySet()){

            String word = entry.getKey().toString();
            if(!magazineMap.containsKey(word)  || magazineMap.get(word) < (int)entry.getValue()){
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }

    static Map<String, Integer> getFrequencies(String[] input){
        Map<String, Integer> map = new HashMap<>();
        for(String word : input){
           if(!map.containsKey(word)){
                map.put(word, 0);
            }
            map.put(word, map.get(word)+1);
        }
        return map;
    }
}
