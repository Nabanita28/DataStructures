package dataStructuresPractice.bfsTraversal;

import dataStructuresPractice.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SumRootLeafNumbers {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(sumNumbers(root));
    }

    static public int sumNumbers(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        sumNumbersRecur(root,"", nums);
        return nums.stream().mapToInt(i-> i).sum();
    }

    static void sumNumbersRecur(TreeNode root, String path, List<Integer> nums){

        if(root == null){
            return;
        }

        path = path + root.key;

        if(root.left == null && root.right == null){
            nums.add(Integer.parseInt(path));
        }else{
            sumNumbersRecur(root.left, path, nums);
            sumNumbersRecur(root.right, path, nums);
        }

        path = path.substring(0, path.length()-1);
    }
}
