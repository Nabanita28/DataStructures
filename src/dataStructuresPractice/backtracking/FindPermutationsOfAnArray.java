package dataStructuresPractice.backtracking;

import java.util.ArrayList;
import java.util.List;

public class FindPermutationsOfAnArray {
    public static void main(String[] args) {
        List<List<Integer>> output = new ArrayList<>();
        int[] nums = {1, 2, 3};
        findPermutations(nums, new ArrayList<>(), output);
        output.stream().forEach(itemList -> {
            itemList.forEach(item -> System.out.print(item + " "));
            System.out.println();
        });
    }

    static void findPermutations(int[] nums, List<Integer> current, List<List<Integer>> output){


        if(current.size() == nums.length){
            output.add(new ArrayList<>(current));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(current.contains(nums[i])){
                continue;
            }
            current.add(nums[i]);
            findPermutations(nums, current, output);
            current.remove(current.size() - 1);
        }
    }
}
