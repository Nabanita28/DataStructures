package dataStructuresPractice.strings.mock.interviews;

import java.util.Arrays;

public class LongestSubstringWithKUniqueCharacters {
    public static void main(String[] args) {
        String str = "aabacbebebe";
        findLongestSubstringWithKUniqueCharacters(str, 3);
    }
    //TODO - revisit
    static final int MAX_CHARS = 26;

    private static void findLongestSubstringWithKUniqueCharacters(String str, int k) {
        int len = str.length();
        int uniqueCharacters = 0;
        int[] count = new int[MAX_CHARS];
        for (int i = 0; i < len; i++) {
            if (count[str.charAt(i) - 'a'] == 0) {
                uniqueCharacters++;
            }
            count[str.charAt(i) - 'a']++;
        }

        if (uniqueCharacters < k) {
            System.out.println("Unique characters less than k");
            return;
        }

        //maintain a window and add elements to the window till it contains less or equal k
        int current_start = 0;
        int current_end = 0;
        int max_window_size = 1;
        int max_window_start = 0;

        Arrays.fill(count, 0);
        count[str.charAt(0) - 'a']++;

        for (int i = 1; i < len; i++) {
            count[str.charAt(i) - 'a']++;
            current_end++;

            while (!isValid(count, k)) {
                count[str.charAt(current_start) - 'a']--;
                current_start++;
            }

            //Update max_window_size if required
            if (current_end - current_start + 1 > max_window_size) {
                max_window_size = current_end - current_start + 1;
                max_window_start = current_start;
            }

        }

        System.out.println("Longest Substring With K Unique Characters : " + str.substring(max_window_start, max_window_start+max_window_size) + " size = " + max_window_size);
    }

    private static boolean isValid(int[] count, int k) {
        int unique = 0;
        for (int j = 0; j < MAX_CHARS; j++) {
            if (count[j] > 0) {
                unique++;
            }
        }
        return (unique <= k);
    }
}