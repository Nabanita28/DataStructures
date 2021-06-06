package dataStructuresPractice.arrays.mockInterviews;

import java.util.*;

public class WordsFromPhoneDigits {
    public static void main(String[] args) {

        System.out.println(printWordsFromPhoneDigits("23"));
    }

    private static List<String> printWordsFromPhoneDigits(String digits) {

        String[] phone = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int n = digits.length();
        List<String> output = new ArrayList<>();

        char[] chars = digits.toCharArray();
        int[] numbers = new int[chars.length];

        for(int i=0; i<chars.length; i++){
            numbers[i] = Integer.parseInt(String.valueOf(chars[i]));
        }

        Queue<String> queue = new LinkedList<>();
        queue.add("");

        while(!queue.isEmpty()){
            String current = queue.remove();

            if(current.length() == n){
                output.add(current);
            }else{

                String value = phone[numbers[current.length()]];

                for(int i=0; i<value.length(); i++){
                    queue.add(current + value.charAt(i));
                }
            }
        }


        return output;
    }
}
