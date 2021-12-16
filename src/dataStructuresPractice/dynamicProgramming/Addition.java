package dataStructuresPractice.dynamicProgramming;

public class Addition {
    public static void main(String[] args) {

        System.out.println(func(3));
    }
    static int func(int n){
        int[] dp = new int[n+1];
        dp[0] = 2;
        dp[1] = 2;
        dp[2] = 2 * dp[0] * dp[1];
        for(int i=3; i<=n; i++){
            dp[i] = (2 * dp[i-1] * dp[i-2]);
        }
        return dp[n];
    }
}
