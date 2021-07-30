package dataStructuresPractice.math;

import java.util.*;
import java.util.stream.Collectors;

public class FourSum {
    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, 1, 2 };
        int n = arr.length;
        int X = 91;
        Map<Integer, Pair> map = getTwoSum(arr, n);

        // Function call
        fourSum(map, arr, X, n);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;

        Map<Integer, Pair> twoSumMap = getTwoSum(nums, n);
        return fourSum(twoSumMap, nums, target, n);
    }

    static class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    static Map<Integer, Pair> getTwoSum(int[] nums, int n){
        Map<Integer, Pair> twoSumMap = new HashMap<>();

        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                int sum = nums[i] + nums[j];
                twoSumMap.put(sum, new Pair(nums[i], nums[j]));
            }
        }
        return twoSumMap;
    }

    static List<List<Integer>> fourSum(Map<Integer, Pair> twoSumMap, int[] nums, int target, int n){

        // Set<Integer> set = new HashSet<>();

        List<List<Integer>> foursums = new ArrayList<>();

        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                int sum = nums[i] + nums[j];

                if(twoSumMap.containsKey(target - sum)){

                    Pair pair = twoSumMap.get(target - sum);

                    if(pair.first != nums[i] && pair.second != nums[i]
                            && pair.first != nums[j] && pair.second != nums[j]){

                        List<Integer> result = new ArrayList<>();
                        result.add(nums[i]);
                        result.add(nums[j]);
                        result.add(pair.first);
                        result.add(pair.second);
                        foursums.add(result);



                    }
                }
            }
        }
        return foursums.stream().distinct().collect(Collectors.toList());
    }
}
