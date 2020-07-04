package arrays;

import java.util.*;

public class UniqueString {
    public static void main(String[] args) {
        System.out.println(isUnique("Nabs"));
    }

    static boolean isUnique(String str){
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        for(int i = 0; i<str.length() -1; i++){
                if(arr[i] == arr[i+1]){
                    return false;
                }
            }
        return true;
    }
}
