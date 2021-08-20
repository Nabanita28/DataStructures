package dataStructuresPractice.strings;

public class KMPPatternMatching {
    public static void main(String[] args) {
        String text = "geeksforgeeks";
        String pat = "geek";
        findAllOccurrencesOfPattern(text, pat);
    }
//time complexity is O(m+n) , m - preprocessing the pattern, n - scanning through the text
    private static void findAllOccurrencesOfPattern(String text, String pat) {

        int m = pat.length();
        int n = text.length();

        int[] lps = new int[m];

        preProcessPattern(pat, lps);
        int i=0, j=0;
        while(i < n){
            if(text.charAt(i) == pat.charAt(j)){
                i++;
                j++;
            }
            if(j == m){
                System.out.println("Pattern found at - " + (i-m));
                j = lps[j-1];
            }
            else if (text.charAt(i) != pat.charAt(j)){
                if(j != 0){
                    j = lps[j-1];
                }else{
                    i++;
                }
            }
        }

    }

    private static void preProcessPattern(String pat, int[] lps) {

        int i=1; int j=0;
        int length = pat.length();

        while(i <  length){
            if(pat.charAt(i) == pat.charAt(j)){
                j++;
                lps[i] = j;
                i++;
            }else if(pat.charAt(i) != pat.charAt(j)){
                if(j != 0){
                    j = lps[j-1];
                } else{
                    lps[i] = j;
                    i++;
                }
            }
        }

    }
}
