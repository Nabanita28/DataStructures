package dataStructuresPractice.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UniqueGeneralizedAbbreviations {
    public static void main(String[] args) {
        List<String> result = generateGeneralizedAbbreviation("BAT");
        System.out.println("Generalized abbreviation are: " + result);
        result = generateGeneralizedAbbreviation("code");
        System.out.println("Generalized abbreviation are: " + result);
    }

    public static class AbbreviatedWord{
        StringBuilder str;
        int totalCharCount;
        int abbreviationCount = 0;
        public AbbreviatedWord(StringBuilder str, int totalCharCount, int abbreviationCount){
            this.str = str;
            this.totalCharCount = totalCharCount;
            this.abbreviationCount = abbreviationCount;
        }
    }


    public static List<String> generateGeneralizedAbbreviation(String word) {
       int wordLen = word.length();
       List<String> result = new ArrayList<>();
       Queue<AbbreviatedWord> queue = new LinkedList<>();
       queue.add(new AbbreviatedWord(new StringBuilder(), 0, 0));

       while(!queue.isEmpty()){

           AbbreviatedWord current = queue.remove();
            if(current.totalCharCount == wordLen){
                if(current.abbreviationCount != 0){
                    current.str.append(current.abbreviationCount);
                }
                result.add(String.valueOf(current.str));
            } else{
                queue.add(new AbbreviatedWord(new StringBuilder(current.str), current.totalCharCount+1, current.abbreviationCount+1));

                if(current.abbreviationCount != 0){
                    current.str.append(current.abbreviationCount);
                }
                queue.add(new AbbreviatedWord(new StringBuilder(current.str).append(word.charAt(current.totalCharCount)), current.totalCharCount+1, 0));
            }
       }
        return result;
    }
}
