package dataStructuresPractice.arrays.mustDo;

public class ContinuousSubArray {
    public static void main(String[] args) {
        int[] arr = new int[]{-2, -3, 4, -1, -2, 1, 5, -3};
        findContinuousSubArray(arr, 6);
        largestSumContiguousSubArray(arr);
    }

    private static void findContinuousSubArray(int[] arr, int sum) {

        int res = arr[0];
        int i = 0;
        int j = i + 1;

        while(i<arr.length && j<arr.length){
            res += arr[j];

            if (res < sum)
                j++;

            if (res > sum){
                res = res - arr[i];
                i++; j++;
            }

            if(res == sum){
                j=j-1;
                System.out.println("Start index = " + i + " End index = " + j);
                break;
            }

        }

    }

    static void largestSumContiguousSubArray(int[] arr){
        int max_so_far = Integer.MIN_VALUE;
        int max_ends_here = 0;

        for (int i=0; i<arr.length; i++){
            max_ends_here = max_ends_here + arr[i];

            if (max_ends_here > max_so_far)
                max_so_far = max_ends_here;

            if (max_ends_here < 0)
                max_ends_here = 0;
        }
        System.out.println("Largest contiguous array sum " + max_so_far);
    }
}
