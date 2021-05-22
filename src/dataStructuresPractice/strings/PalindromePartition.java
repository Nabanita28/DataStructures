package dataStructuresPractice.strings;

import java.util.ArrayList;
import java.util.List;

import static dataStructuresPractice.arrays.mustDo.Palindrome.isPalindrome;

public class PalindromePartition {
    public static void main(String[] args) {
        String input = "aab";
        List<List<String>> output = new ArrayList<>();
        backtrack(input, 0, new ArrayList<>(), output);
        output.forEach(s-> System.out.print(s + " "));
    }

   static void  backtrack(String input, int index, List<String> current, List<List<String>> output){
        if(index >= input.length()){
            output.add(new ArrayList<>(current));
            return;
        }

        for(int i=index; i<input.length(); i++){
            if(isPalindrome(input, index, i)){
                current.add(input.substring(index, i+1));
                backtrack(input, i+1, current, output);
                current.remove(current.size()-1);
            }
        }
    }

    static boolean isPalindrome(String input, int start, int index){
        while(start < index){
            if(input.charAt(start++) != input.charAt(index--)){
                return false;
            }
        }
        return true;
    }
}
