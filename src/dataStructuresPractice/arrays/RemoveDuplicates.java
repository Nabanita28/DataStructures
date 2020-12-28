package dataStructuresPractice.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int newLength = removeDuplicates(nums);
        for(int i=0; i<newLength; i++){
            System.out.println(nums[i]);
        }

        removeDuplicates("gfg");
    }

    private static int removeDuplicates(int[] nums) {
    int j = 0;
    for(int i = 0; i < nums.length; i++){
        if(i<(nums.length -1) && nums[i] == nums[i+1]){
            continue;
        }
        nums[j++] = nums[i];
    }
    return j;
    }


    private static void removeDuplicates(String S) {
        List<Character> list = new ArrayList<>();
        S = S.toLowerCase();
       for(int i=0; i<S.length(); i++){

            if(!list.contains(S.charAt(i))){
                list.add(S.charAt(i));
            }
        }
        String result =  list.stream().map(String::valueOf).collect(Collectors.joining());
        System.out.println(result);

    }


}
