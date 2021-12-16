package algoProblems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ThreeProductSum {
    public static void main(String[] args) {
        int[] input = {3,0,-2,-1,1,2};
        int target = 0;
        List<Result> output = findSum(input, target);

        for(Result res : output){
            System.out.println( res.i + " " + res.j + " " + res.k);
        }

    }

    private static List<Result> findSum(int[] input, int target) {

        int n = input.length;
        int i=0;
        Arrays.sort(input);
        List<Result> results = new ArrayList<>();

        while (i < n-1){
            int j = i+1;
            int k = n-1;

            while(j<n && k>i){

                int actualSum = input[i] + input[j] + input[k];
                if(target == actualSum){
                    Result res = new Result(input[i], input[j], input[k]);
                    results.add(res);
                    i++;
                } else if (target < actualSum){
                    k--;
                } else if(target > actualSum){
                    j++;
                }
            }
            i++;
        }
        return results.stream().distinct().collect(Collectors.toList());
    }

    static class Result{
        int i;
        int j;
        int k;

        public Result(int i, int j, int k){
            this.i = i;
            this.j = j;
            this.k = k;
        }
    }
}
