package algoProblems.arrays;

import java.util.HashSet;
import java.util.Set;

public class ThreeNumberSum {
    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 10, 8};
        int sum = 22;
        findTriplet(arr, sum);
    }

    private static void findTriplet(int[] arr, int sum) {

        Set<Integer> uniqueSet = new HashSet<>();

        for (int i=0; i<arr.length-2; i++){
            int new_sum = sum - arr[i];

            for(int j=i+1; j<arr.length; j++){
                int compliment = new_sum - arr[j];
                if (uniqueSet.contains(compliment)){

                      
                    System.out.println(arr[i] + ", " + arr[j] + " ," + compliment);
                    return;
                }
                    uniqueSet.add(arr[j]);

            }
        }

    }
}
