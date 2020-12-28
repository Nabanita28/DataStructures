package dataStructuresPractice.hashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AnagramPairsInAString {
    public static void main(String[] args) {
        System.out.println(sherlockAndAnagrams("ifailuhkqq"));
    }
    static int sherlockAndAnagrams(String s) {

        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            for(int j=i; j<s.length(); j++){
                char[] ch = s.substring(i, j+1).toCharArray();
                Arrays.sort(ch);
                String newChar = new String(ch);

                if(map.containsKey(newChar)){
                    map.put(newChar, map.get(newChar) + 1);
                } else{
                    map.put(newChar, 1);
                }
            }
        }
        int anagramPair = 0;
        for(String subStr : map.keySet()){
            int count = map.get(subStr);
            anagramPair = anagramPair + (count*(count-1)/2);
        }
        return anagramPair;
    }
}
