package dataStructuresPractice.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SumClosest {
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int closestDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int result = 0;

        for(int i=0; i<nums.length-2; i++){
            int j = i+1;
            int k = nums.length-1;


            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                int difference = Math.abs(sum - target);

                if( sum > target){
                    k--;
                } else{
                    j++;
                }

                if(difference < closestDiff){
                    result = sum;
                }
                closestDiff = Math.min(closestDiff, difference);
            }
        }
        return result;
    }
}

