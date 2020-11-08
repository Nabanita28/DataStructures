package practise;

import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        removeDuplicates(nums);
    }

    public static int[] removeDuplicates(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            map.put(nums[i], 1);
        }

        System.out.println(map.get(nums[0]));

        List<Integer> list = new ArrayList<>();

        int[] arr = list.stream().mapToInt(i-> i).toArray();
        return arr;
    }
}
