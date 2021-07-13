package dataStructuresPractice.dynamicProgramming.mock.interviews;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }
    public static String longestPalindrome(String s) {
        int n = s.length();

        boolean[][] dp = new boolean[n][n];

        for(int i=0; i<n; i++){
            dp[i][i] = true;
        }

        int maxLength = 1;
        int start = 0;
        //find length of substring 2
        for(int i=0; i<n-1; i++){

            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                start = i;
                maxLength = 2;
            }
        }

        for(int k=3; k<=n; k++){
            for(int i=0; i<n-k+1; i++){
                int j = i+k-1;

                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;
                    //set a new max
                    if(k>maxLength){
                        maxLength = k;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start+maxLength);
    }
}
