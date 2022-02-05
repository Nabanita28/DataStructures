package dataStructuresPractice.cyclicSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllMissingNumbers {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        findDisappearedNumbers(nums).forEach(i -> System.out.print(i + " "));
    }

    static public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> result = new ArrayList<>();

        for(int i=0; i<nums.length; i++){

            while( nums[i] != nums[nums[i]-1] ){
                int temp = nums[i];
                nums[i] = nums[temp-1];
                nums[temp-1] = temp;
            }
        }

        for(int i=0; i<nums.length; i++){
            if(nums[i] != i+1){
                result.add(nums[i]);
            }
        }
        return result;
    }
}
