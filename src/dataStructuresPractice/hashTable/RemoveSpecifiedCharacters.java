package dataStructuresPractice.hashTable;

import java.util.HashMap;
import java.util.Map;

public class RemoveSpecifiedCharacters {
    public static void main(String[] args) {
        String sentence = "geeksforgeeks  ";
        String chars = "mask";
        //System.out.println(removeSpecifiedChars(sentence, chars));
        System.out.println(removeSpecifiedCharacters(sentence, chars));
    }

    private static String removeSpecifiedCharacters(String sentence, String chars) {

        int[] charsArray = new int[256];

        for(int i=0; i<chars.length(); i++){
            charsArray[chars.charAt(i)]++;
        }
        char[] result = new char[sentence.length()];
        for(int i=0; i<sentence.length(); i++){
            if(charsArray[sentence.charAt(i)] == 1){
                continue;
            }
            result[i] = sentence.charAt(i);
        }
        return new String(result);
    }

    private static String removeSpecifiedChars(String sentence, String chars) {
        Map<Character, Character> charsMap = new HashMap<>();

        for(int i=0; i<chars.length(); i++){
            charsMap.put(chars.charAt(i), chars.charAt(i));
        }
        char[] result = new char[sentence.length()];

        for(int i=0; i<sentence.length(); i++){
            if(charsMap.containsKey(sentence.charAt(i))){
                continue;
            }
            result[i] = sentence.charAt(i);
        }

       return new String(result);
    }
}
