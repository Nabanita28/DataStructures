package dataStructuresPractice.dynamicProgramming.mock.interviews;

public class EqualPartitionSum {
    public static void main(String[] args) {
        System.out.println(equalPartition(4, new int[]{1, 5, 11, 5}));
    }
    static boolean equalPartition(int N, int arr[])
    {

        int sum = 0;
        for(int i=0; i<N; i++){
            sum = sum + arr[i];
        }

        if(sum%2 != 0){
            return false;
        }

        boolean[][] dp = new boolean[N+1][sum/2+1];

        for(int i=0; i<=N; i++){
            //by excluding  dp[0][1], we can find sum 0
            dp[i][0] = true;
        }

        for(int i=1; i<=sum/2; i++){
            //if we have no elements, we cannot find any sum
            dp[0][i] = false;
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=sum/2; j++){
               dp[i][j] = dp[i-1][j];

                if(j >= arr[i-1]){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]] ;
                }
            }
        }

        return dp[N][sum/2];
    }
}
