package algoProblems.arrays;

import java.util.Arrays;

public class SmallestDifference {
    //Given two arrays of integers, compute the pair of values (one value in each array)
    // with the smallest (non-negative) difference. Return the difference.
    public static void main(String[] args) {
        int[] first = {1, 2, 11, 15};
        int[] second = {4, 12, 19, 23, 127, 235};
        System.out.println("Smallest Difference is : " + findSmallestDifference(first, second));
    }

    private static int findSmallestDifference(int[] first, int[] second) {

        Arrays.sort(first);
        Arrays.sort(second);
        int min = Integer.MAX_VALUE;

        int i=0, j=0;
        while( i < first.length  && j < second.length){
            int diff = Math.abs(first[i] - second[j]);

            if (min > diff){
                min = diff;
            }

            if (i < (first.length-1) && j < (first.length-1) && first[i+1] > second[j+1]){
                j++;
            }else{
                i++;
            }

        }
        return min;
    }
}
