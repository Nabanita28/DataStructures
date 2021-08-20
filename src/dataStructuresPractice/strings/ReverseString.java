package dataStructuresPractice.strings;

public class ReverseString {

    public static void main(String[] args) {
        System.out.println(reverseString("Nabanita"));
        reverseWordsInASentence("This is a Career Monk String");
    }

    private static void reverseWordsInASentence(String sentense) {
        String[] words = sentense.split(" ");
        for(int i = words.length-1; i>=0; i--){
            System.out.print(words[i] + " ");
        }
    }

    private static String reverseString(String text) {
        char[] textChars = text.toCharArray();
        int start = 0;
        int end= text.length()-1;
        while(start < end){
            textChars[start] =  (char) (textChars[start] ^ textChars[end]);
            textChars[end] ^= textChars[start];
            textChars[start] ^= textChars[end];
            start++;
            end--;
        }

        return new String(textChars);
    }

}
