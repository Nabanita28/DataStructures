package dataStructuresPractice.cyclicSort;

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] nums = {1, 5, 6, 4, 3, 2};
        Arrays.stream(cyclicSort(nums)).forEach(i -> System.out.print(i + " "));
    }

    private static int[] cyclicSort(int[] nums) {

        for(int i=0; i<nums.length; i++){
            while(nums[i] != i+1){
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
            i++;
        }
        return nums;
    }


}
