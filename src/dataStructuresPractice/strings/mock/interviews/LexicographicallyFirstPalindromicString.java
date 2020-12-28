package dataStructuresPractice.strings.mock.interviews;

public class LexicographicallyFirstPalindromicString {
    public static void main(String[] args) {
        String s = "malayalam";
        printLexicographicallyFirstPalindromicString(s);
    }

    static int MAX_CHARS = 26;
    private static void printLexicographicallyFirstPalindromicString(String input) {
        int[] frequency = new int[MAX_CHARS];
        countFrequency(frequency, input);

        if(!canMakePalindrome(frequency, input)){
             System.out.println("Not possible");
            return;
        }

        char oddChar = '\0';
        for (int i=0; i<MAX_CHARS; i++){
            if (frequency[i] % 2 != 0){
                oddChar = (char)(i + 'a');
            }
        }

        String front_str = "";
        String rear_str = "";
        char ch;
        for (int i=0; i<MAX_CHARS; i++){
            String temp = "";
            ch = (char)(i + 'a');
            for (int j=1; j<=frequency[i]/2; j++){
                temp = temp + ch;
            }
            front_str = front_str + temp;
            rear_str = temp + rear_str;
        }

        System.out.println(front_str + oddChar + rear_str);
    }

    private static boolean canMakePalindrome(int[] frequency, String input) {
        int oddCharCount = 0;
        for (int i = 0; i <MAX_CHARS; i++) {
            if (frequency[i] % 2 != 0){
                oddCharCount++;
            }
        }
        if (oddCharCount > 1){
            return false;
        }
        return true;
    }
    private static void countFrequency(int[] frequency, String input) {
        for (int i=0; i<input.length(); i++){
            frequency[input.charAt(i) - 'a']++;
        }
    }
}
