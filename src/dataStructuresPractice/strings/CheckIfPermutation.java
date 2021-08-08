package dataStructuresPractice.strings;

public class CheckIfPermutation {
    public static void main(String[] args) {
        String s = "god   ";
        String t = "dog";
        System.out.println(checkIfPermutation(s, t));
    }

    static boolean checkIfPermutation(String str1, String str2){

        if(str1.length() != str2.length()){
            return false;
        }
        //check with interviewer the size of the character set
        int[] letters = new int[128];

        for(int i=0; i<str1.length(); i++){
            letters[str1.charAt(i) - 'a']++;
        }

        for(int i=0; i<str2.length(); i++){
           letters[str2.charAt(i) - 'a']--;

            if(letters[str2.charAt(i) - 'a'] < 0){
                return false;
            }
        }
        return true;
    }
}
