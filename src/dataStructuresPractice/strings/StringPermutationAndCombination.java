package dataStructuresPractice.strings;

public class StringPermutationAndCombination {
    public static void main(String[] args) {
        printDistinctPermutations("abc", "");
        System.out.println("Combination - ");
        printCombinations(0, "wxyz");
    }

    static void printDistinctPermutations(String str, String ans){

        //base condition
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }

        boolean[] used = new boolean[26];
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            String ros = str.substring(0, i) + str.substring(i+1);

            if(!used[ch - 'a']){
                printDistinctPermutations(ros, ans+ch);
            }
            used[ch - 'a'] = false;
        }
    }

    static StringBuilder output = new StringBuilder();
    static void printCombinations(int start, String originalText){
        for(int i=start; i<originalText.length(); i++){
            output.append(originalText.charAt(i));
            System.out.println(output);
            if(i<originalText.length()){
                printCombinations(i+1,originalText);
                output.setLength(output.length()-1);
            }
        }
    }
}
