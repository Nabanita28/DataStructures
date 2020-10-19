package arrays.mockInterviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordsFromPhoneDigits {
    public static void main(String[] args) {
        List<List<Character>> keypad = Arrays.asList(
                // 0 and 1 digit don't have any characters associated
                Arrays.asList(),
                Arrays.asList(),
                Arrays.asList( 'A', 'B', 'C' ),
                Arrays.asList( 'D', 'E', 'F' ),
                Arrays.asList( 'G', 'H', 'I' ),
                Arrays.asList( 'J', 'K', 'L' ),
                Arrays.asList( 'M', 'N', 'O' ),
                Arrays.asList( 'P', 'Q', 'R', 'S'),
                Arrays.asList( 'T', 'U', 'V' ),
                Arrays.asList( 'W', 'X', 'Y', 'Z')
        );
        int[] input = new int[]{2,3,4};
        printWordsFromPhoneDigits(keypad, input);
    }

    private static void printWordsFromPhoneDigits(List<List<Character>> keypad, int[] input) {

        List<String> output = new ArrayList<>();

        for( char c : keypad.get(input[0])) {
            output.add(String.valueOf(c));
        }
        /// for each character associated with current digit in the keypad
        for (int i=1; i<input.length; i++){
            List<String> prevList = new ArrayList<>(output);
            output.clear();

            for (char c : keypad.get(input[i])){
                for (String s : prevList){
                    // append current character to each word in the output list
                    output.add(s+c);
                }
            }
        }
        System.out.println(output);
    }
}
