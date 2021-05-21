package dataStructuresPractice.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FindSubSetsFromArray {

    public static void main(String args[]) {

        List<List<Integer>> output = new ArrayList<>();
        int[] nums = {1, 2, 3};
        backtrack(nums, 0, new ArrayList<>(), output );
        output.stream().forEach(itemList -> {
            itemList.forEach(item -> System.out.print(item + " "));
            System.out.println();
        });
    }

    static void backtrack(int[] nums, int index, List<Integer> current, List<List<Integer>> output){

        output.add(new ArrayList<>(current));

        for(int i=index; i<nums.length; i++){

            current.add(nums[i]);
            backtrack(nums, i+1, current, output);
            current.remove(current.size()-1);
        }

    }

}
