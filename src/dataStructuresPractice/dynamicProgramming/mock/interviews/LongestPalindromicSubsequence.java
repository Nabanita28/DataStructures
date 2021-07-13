package dataStructuresPractice.dynamicProgramming.mock.interviews;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String seq = "bbbab";
        int n = seq.length();
        System.out.println("The length of the lps is "+ lps(seq));
    }

    static int lps(String s)
    {
        int n = s.length();

        int[][] dp = new int[n][n];

        for(int i=0; i<n; i++){
            dp[i][i] = 1;
        }

        for(int k=2; k<=n; k++){
            for(int i=0; i<n-k+1; i++){
                int j = i+k-1;

                if(s.charAt(i) == s.charAt(j) && k==2)
                    dp[i][j] = 2;
                else if(s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i+1][j-1] + 2;
                else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);

            }
        }

        return dp[0][n-1];
    }
}
