package dataStructuresPractice.arrays.mustDo;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("redivider"));
    }

    public static boolean isPalindrome(String s) {
        boolean flag = true;
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                flag = false;
                break;
            }
        }

        return flag;
    }
}
