package dataStructuresPractice.strings;

import java.util.HashMap;
import java.util.Map;
public class PermutationInString {
    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidboaoo"));
    }

    public static boolean checkInclusion(String s1, String s2) {

        Map<Character, Integer> freqMapS1 = new HashMap<>();
        Map<Character, Integer> freqMapS2 = new HashMap<>();

        for(int i=0; i<s1.length(); i++){
            freqMapS1.put(s1.charAt(i), freqMapS1.getOrDefault(s1.charAt(i), 0)+1);
            freqMapS2.put(s2.charAt(i), freqMapS2.getOrDefault(s2.charAt(i), 0)+1);
        }

        int start = 0;
        for(int end=0; end<s2.length()-s1.length(); end++){

            if(matches(freqMapS1, freqMapS2, s1, s2)){
                return true;
            }
            freqMapS2.put(s2.charAt(start+s1.length()), freqMapS2.get(s2.charAt(start+s1.length()))-1);
            freqMapS2.put(s2.charAt(end), freqMapS1.getOrDefault(s2.charAt(end), 0)+1);
        }

        return false;
    }

    static boolean matches(Map<Character, Integer> freqMapS1, Map<Character, Integer> freqMapS2, String s1, String s2){

        for(int i=0; i<s1.length(); i++){
            if(freqMapS1 != freqMapS2){
                return false;
            }
        }
        return true;
    }
}
