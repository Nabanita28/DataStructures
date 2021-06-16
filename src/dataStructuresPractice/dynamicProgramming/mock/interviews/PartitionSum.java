package dataStructuresPractice.dynamicProgramming.mock.interviews;

public class PartitionSum {
    public static void main(String[] args) {
        System.out.println(equalPartition(4, new int[]{1, 5, 11, 5}));
    }
    static int equalPartition(int N, int arr[])
    {

        int sum = 0;
        for(int i=0; i<N; i++){
            sum = sum + arr[i];
        }

        if(sum%2 != 0){
            return 0;
        }

        int[][] dp = new int[N+1][sum+1];

        for(int i=0; i<=N; i++){
            //by excluding  dp[0][1], we can find sum 0
            dp[i][0] = 1;
        }

        for(int i=0; i<=sum; i++){
            //if we have no elements, we cannot find any sum
            dp[0][1] = 0;
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=sum; j++){
                if(j < arr[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                if(j >= arr[i-1]){
                    dp[i][j] = dp[i-1][j-arr[i-1]] ;
                }
            }
        }

        return dp[N][sum];
    }
}
