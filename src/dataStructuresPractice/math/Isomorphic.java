package dataStructuresPractice.math;

import java.util.HashMap;
import java.util.Map;

public class Isomorphic {
//TODO - Revisit
    public static void main(String[] args) {
        System.out.println(isIsomorphic("bbbaaaba", "aaabbbba"));
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int n = s.length();

        Map<Character, Character> mapS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!mapS.containsKey(s.charAt(i))) {
                mapS.put(s.charAt(i), t.charAt(i));
            }
        }

        Map<Character, Character> mapT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (!mapT.containsKey(t.charAt(i))) {
                mapT.put(t.charAt(i), s.charAt(i));
            }
        }

        int i = 0;
        while (i < n) {
            if (!(mapS.get(s.charAt(i)) == t.charAt(i) && mapT.get(t.charAt(i)) == s.charAt(i))) {
                return false;
            }
            i++;
        }
        return true;
    }
}
