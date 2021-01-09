package algoProblems.tree.binaryTrees;

import dataStructuresPractice.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
//How to Calculate The Branch Sums of A Binary Tree
public class BranchSums {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left    = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right   = new TreeNode(3);
        root.left.right = new TreeNode(5);

        System.out.println(branchSums(root));
    }

    private static List<Integer> branchSums(TreeNode root) {

        List<Integer> sumArray = new ArrayList<>();
        int runningSum = 0;
        calculateBranchSums(root, sumArray, runningSum);
        return sumArray;
    }

        private static void calculateBranchSums(TreeNode root, List<Integer> sumArray, int runningSum) {

            if (root == null){
                return;
            }

            int newRunningSum = runningSum + root.key;

            if (root.left == null && root.right == null){
                sumArray.add(newRunningSum);
            }
            calculateBranchSums(root.left, sumArray, newRunningSum);
            calculateBranchSums(root.right, sumArray, newRunningSum);
        }
}
