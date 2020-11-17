package dynamicProgramming.mock.interviews;

public class FindMaxSumWithNoAdjacent {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 7, 10};
        findMaxSum(arr);
    }
    ///Maximum money 
    private static void findMaxSum(int[] arr) {
        int n = arr.length;
        int[] sum = new int[n];

        sum[0] = arr[0];
        sum[1] = Math.max(arr[0], arr[1]);

        for (int i=2; i< n; i++){
            //sum[i] = max(sum if ith house is selected, sum if ith house is NOT selected)
            sum[i] = Math.max(sum[i-2]+ arr[i], sum[i-1]);
        }
        System.out.println(sum[n-1]);
    }
}
