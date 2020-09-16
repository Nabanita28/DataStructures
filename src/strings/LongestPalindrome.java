package strings;

public class LongestPalindrome {

    public static void main(String[] args) {
        findLongestPalindrome("forgeeksskeegfor");
    }

    private static void findLongestPalindrome(String s) {

        int n = s.length();
        int low = 0;
        int high = 0;
        int max_length = 1;
        int start = 0;
        //odd length
        for (int i = 1; i < n; i++) {
            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < n && s.charAt(low) == s.charAt(high)) {
                if (high - low + 1 > max_length) {
                    start = low;
                    max_length = high - low + 1;
                }
                low--;
                high++;
            }
        }
            //even length
        for (int i=1; i<n; i++){
                low = i - 1;
                high = i;
                while (low >= 0 && high < n && s.charAt(low) == s.charAt(high)) {
                    if (high - low + 1 > max_length) {
                        start = low;
                        max_length = high - low + 1;
                    }
                    low--;
                    high++;
                }
            }
        System.out.println("Length is : " + max_length);
        System.out.println("Palindrome is : " + s.substring(start, start + max_length - 1));
        }
}
