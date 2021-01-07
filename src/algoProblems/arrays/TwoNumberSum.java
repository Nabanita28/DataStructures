package algoProblems.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TwoNumberSum {
    public static void main(String[] args) {
        int[] arr = {1, -2, 1, 0, 5};
        int sum = 0;
        twoNumberSum(arr, sum);
    }

    private static void twoNumberSum(int[] arr, int sum) {

        int complement = 0;
        List<Integer> numbers = Arrays.stream(arr).boxed().collect(Collectors.toList());
        for(int     i=0; i<numbers.size(); i++){
            int item = numbers.get(i);
            complement = sum - item;

            if(numbers.contains(complement)){
                System.out.println(item + ", " + complement);
            }

        }
    }
}
