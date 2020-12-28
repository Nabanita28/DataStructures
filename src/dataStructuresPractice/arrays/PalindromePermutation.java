package dataStructuresPractice.arrays;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {
    public static void main(String[] args) {
        System.out.println(isPermutation("abba"));
    }

    //Given a string, Check if characters of the given string can be rearranged to form a palindrome.
    public static boolean isPermutation(String s){
        char[] arr = s.toCharArray();
        Map<Character, Integer> m = new HashMap<>();
        Character ch;
        for(int i=0; i<arr.length; i++){

            //convert all characters to lower case
            ch = Character.toLowerCase(arr[i]);
            if(ch <'a' || ch > 'z') continue;
                if (m.containsKey(ch)) {
                    m.put(ch, m.get(ch) + 1);
                } else {
                    m.put(ch, 1);
                }

        }
        int oddCharacterCount = 0;
        for(Map.Entry entry : m.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
            if((int) entry.getValue() % 2 != 0){
                oddCharacterCount++;
                if(oddCharacterCount > 1)
                    return false;
            }
        }

        return true;
    }
}
