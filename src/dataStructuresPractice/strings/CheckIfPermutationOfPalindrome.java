package dataStructuresPractice.strings;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckIfPermutationOfPalindrome {
    public static void main(String[] args) {
        String s = "Tact Coa";
        System.out.println(checkIfPermutationOfAPalindrome(s));
    }
    //palindrome must have even number of characters, at max 1 odd character
    static boolean checkIfPermutationOfAPalindrome(String permutation){

        permutation = permutation.toLowerCase().trim();
        permutation = permutation.replaceAll("\\s", "");
        Map<Character, Integer> freqCount = new HashMap<>();
        int oddCount = 0;
        for(int i=0; i<permutation.length(); i++){
            char letter = permutation.charAt((i));
            freqCount.put(letter, (freqCount.getOrDefault(letter, 0))+1);
            if(freqCount.get(letter) % 2 == 1){
                oddCount++;
            }else{
                oddCount--;
            }
        }
        return oddCount >= 1;
        /*boolean foundOdd = false;
        for(Map.Entry entry : freqCount.entrySet()){
            int val = (int)entry.getValue();
            if(val % 2 == 1){
                if(foundOdd){
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;*/
    }
}
