package dataStructuresPractice.recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintAllCombinationOfBalancedParentheses {

    public static void main(String[] args) {
        List<String> output_strings = new ArrayList<>();
        backtrack(output_strings, "", 3, 0, 0);
         output_strings.stream().forEach(s -> System.out.println(s + " "));
    }

    static void backtrack(List<String> output_strings, String currentString, int n, int open, int close){

        //base case
        if(currentString.length() == n*2){
            output_strings.add(currentString);
            return;
        }

        if(open < n){
            backtrack(output_strings, currentString + "(", n, open + 1, close);
        }
        if(open > close){
            backtrack(output_strings, currentString + ")", n, open, close + 1);
        }
    }
}
