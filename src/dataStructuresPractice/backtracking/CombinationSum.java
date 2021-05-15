package dataStructuresPractice.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        int[] candidates = {2,4,6,8};
        List<List<Integer>> output = new ArrayList<>();
        findCombinations(candidates, 8, 0, new ArrayList<>(),output);

        output.stream().forEach(itemList-> {
            System.out.println();
            itemList.forEach(item -> System.out.print(item + " "));
        });
    }

    static void findCombinations(int[] candidates, int target, int index, List<Integer> current, List<List<Integer>> output){

        if (target < 0)
            return;

        if (target == 0){
            output.add(new ArrayList<>(current));
            return;
        }

        for(int i=index; i<candidates.length; i++){
            current.add(candidates[i]);
            findCombinations(candidates, target-candidates[i], i, current, output);
            current.remove(current.size() - 1);
        }
    }
}
