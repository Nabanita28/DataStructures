package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("redivider"));
    }

    public static boolean isPalindrome(String s){
        boolean flag = true;
        char[] arr = s.toCharArray();
        int i = 0;
        int j = s.length() -1;
        while(i<j){
            if (arr[i] == arr[j]){
                i++;
                j--;
            }
            else{
                flag = false;
                break;
            }
        }

        return flag;
    }
}
