package linkedList.mock.interviews;

import java.util.HashSet;
import java.util.Set;

public class PalindromicSubStrings {
    public static void main(String[] args) {
        String s = "abaaa";
        findAllPalindromicSubStrings(s);
    }

    private static void findAllPalindromicSubStrings(String str) {
        Set<String> set = new HashSet<>();
        for (int i =0; i<str.length(); i++){
            //for odd
            expand(str, i, i, set);

            //for even
            expand(str, i, i+1, set);

        }

        System.out.println(set);
    }

    private static void expand(String str, int low, int high, Set<String> set) {

        while(low >= 0 && high < str.length() && str.charAt(low) == str.charAt(high)){
            set.add(str.substring(low, high+1));
            low--;
            high++;
        }
    }
}
