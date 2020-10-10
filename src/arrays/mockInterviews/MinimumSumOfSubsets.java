package arrays.mockInterviews;

import java.util.*;

public class MinimumSumOfSubsets {
    public static void main(String[] args) {
        int[] arr = new int[]{1,6,11,5};
        findMinimumSumOfSubsets(arr);
    }

    private static void findMinimumSumOfSubsets(int[] arr) {
        int sum1 = 0;
        int sum2 = 0;
        List<Integer> sumArr1 = new ArrayList<>();
        List<Integer> sumArr2 = new ArrayList<>();

     Arrays.sort(new int[][]{arr}, Collections.reverseOrder());

     for (int i=0; i<arr.length; i++){
         if (sum1 < sum2){
             sum1 = sum1 + arr[i];
             sumArr1.add(arr[i]);

         }else{
             sum2 = sum2 + arr[i];
             sumArr2.add(arr[i]);
         }
     }
        System.out.println("Minimum sum of subsets is : " + Math.abs(sum1-sum2));
        System.out.print("Subset 1 = ");
        sumArr1.forEach(value -> System.out.print(value + " "));
        System.out.println();
        System.out.print("Subset 2 = ");
        sumArr2.forEach(s -> System.out.print(s + " "));
    }
}
