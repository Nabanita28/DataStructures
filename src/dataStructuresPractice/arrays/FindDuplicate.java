package dataStructuresPractice.arrays;

import java.util.Arrays;

public class FindDuplicate {
    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1,3,4,2,2}));

    }

    public static int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] != nums[i+1]) {
                continue;
            }
            result = nums[i];
            break;
        }
        return result;
    }
}
