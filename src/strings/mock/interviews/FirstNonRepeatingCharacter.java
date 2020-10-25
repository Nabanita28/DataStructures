package strings.mock.interviews;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String s = "rajeevranjan";
        findFirstNonRepeatingCharacter(s);
    }

    private static void findFirstNonRepeatingCharacter(String str) {

        Map<Character, Integer> charMap = new TreeMap<>();

        for (int i = 0; i < str.length(); i++) {
            if (charMap.containsKey(str.charAt(i))) {
                charMap.put(str.charAt(i), charMap.get(str.charAt(i)) + 1);
            } else {
                charMap.put(str.charAt(i), 1);
            }

        }
        for (Map.Entry entry : charMap.entrySet()) {
            if (entry.getValue().equals(1)) {
                System.out.println("First Non-Repeating Character is " + entry.getKey());
                break;
            }
        }
    }
}
