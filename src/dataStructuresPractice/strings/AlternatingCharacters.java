package dataStructuresPractice.strings;

public class AlternatingCharacters {
    public static void main(String[] args) {
        String s = "AABBAABB";
        System.out.println(alternatingCharacters(s));
    }

    static int alternatingCharacters(String s) {
        int count = 0;
        for(int i=0; i<s.length()-1; i++){
            if(s.charAt(i) != s.charAt(i+1)){
                continue;
            } else{
                count++;
            }
        }
        return count;
    }
}
