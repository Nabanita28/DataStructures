package dataStructuresPractice.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = twoSum(new int[]{5,6,7,2,1,4,3}, 7);
        for (int i=0; i<nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }
    //if array is sorted
   /*private static int[] twoSum(int[] arr, int target) {
        int j = arr.length - 1;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] + arr[j] == target){
                return new int[]{i, j};
            } else if(arr[i] + arr[j] < target) continue;
              else if(arr[i] + arr[j] > target){
                 while(arr[i] + arr[j] != target){
                     j--;
                 }
                  return new int[]{i, j};
            }
        }
        throw new IllegalArgumentException("no two sum available");
    }
*/

    private static int[] twoSum(int[] nums, int target) {
        //Map of (value, index)
        Map<Integer, Integer> map = new HashMap<>();
        int compliment = 0;
        for(int i=0; i<nums.length; i++) {
            compliment = target - nums[i];
            if (map.containsKey(compliment)) {
                return new int[]{map.get(compliment), i};

            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution available");
    }
    /*public static int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        for(int i = 0; i<nums.length; i++){
            for (int j=i+1; j< nums.length; j++){
                if(nums[i] + nums[j] == target){
                    arr[0] = i;
                    arr[1] = j;
                    break;
                }
            }
        }
        return arr;
    }*/
}
