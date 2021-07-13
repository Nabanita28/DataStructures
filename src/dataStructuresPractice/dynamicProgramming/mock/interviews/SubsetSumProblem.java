package dataStructuresPractice.dynamicProgramming.mock.interviews;

public class SubsetSumProblem {
    public static void main(String[] args) {
        System.out.println(equalPartition(10, new int[]{3, 2, 3}));
    }
    static boolean equalPartition(int sum, int arr[])
    {
        int n = arr.length;

        boolean[][] dp = new boolean[n+1][sum+1];

        for(int i=0; i<=n; i++){
            //by excluding  dp[0][1], we can find sum 0
            dp[i][0] = true;
        }

        for(int i=1; i<=sum; i++){
            //if we have no elements, we cannot find any sum
            dp[0][i] = false;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum; j++){
                dp[i][j] = dp[i-1][j];

                if(j >= arr[i-1]){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]] ;
                }
            }
        }

        return dp[n][sum];
    }
}
