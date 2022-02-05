package dataStructuresPractice.arrays;

public class MinContiguousSubArraySum {
    public static void main(String[] args) {
        int[] arr = {2,1,5,2,8};
        System.out.println(findMinSubArray(7, arr));
    }
//smallest contiguous subarray whose sum is greater than or equal to ‘S’
        public static int findMinSubArray(int S, int[] arr) {

            int minLen = Integer.MAX_VALUE;
            int len = 0;
            int start = 0;
            int sum = 0;

            for(int end = 0; end<arr.length; end++){

                sum = sum + arr[end];

                while(sum >= S){

                    len = end - start + 1;
                    minLen = Math.min(len, minLen);

                    sum = sum - arr[start];
                    start++;
                }
            }
            return minLen;
        }


}
