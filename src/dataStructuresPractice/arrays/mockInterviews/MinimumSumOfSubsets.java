package dataStructuresPractice.arrays.mockInterviews;

import java.util.*;

public class MinimumSumOfSubsets {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 6, 5, 11};
        System.out.println(findMinimumSumOfSubsets(arr, arr.length));
    }

    //Partition a set into two subsets such that the difference of subset sums is minimum
    private static int findMinimumSumOfSubsets(int[] arr, int n) {
        {
            int sum = 0;

            for (int i = 0; i < n; i++) {
                sum = sum + arr[i];
            }

            boolean[][] dp = new boolean[n + 1][sum + 1];

            for (int i = 0; i <= n; i++) {
                dp[0][i] = false;
            }

            for (int i = 0; i <= n; i++) {
                dp[i][0] = true;
            }


            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= sum; j++) {

                    dp[i][j] = dp[i - 1][j];
                    if (j >= arr[i - 1]) {
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                    }
                }
            }
            //find min sum - diff = abs(s2 - s1); => abs(sum - s1 - s1); => abs(sum - 2s1); s2 <= s2
            int minDiff = Integer.MAX_VALUE;
            for (int i = 0; i <= sum / 2; i++) {
                int first = i;
                int second = sum - i;
                if (dp[n][i] == true && minDiff > Math.abs(first - second)) {
                    minDiff = Math.abs(second - first);
                }

            }
            return minDiff;

        }
    }
}
