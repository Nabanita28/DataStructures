package dataStructuresPractice.bfsTraversal;

import dataStructuresPractice.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MaxSumPath {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(-4);
        System.out.println(maxPathSum(root));
    }

    public static int maxPathSum(TreeNode root)
    {
        List<Integer> sum = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        maxPathSumRecur(root, sum, path);
        return sum.stream().mapToInt(i->i).max().getAsInt();
    }

    static void maxPathSumRecur(TreeNode root, List<Integer> sum, List<Integer> path){
        if(root == null){
            return;
        }

        path.add(root.key);

        if(root.left == null && root.right == null){
            sum.add(path.stream().mapToInt(i->i).sum());
        } else{
            maxPathSumRecur(root.left, sum, path);
            maxPathSumRecur(root.right, sum, path);
        }
        path.remove(path.size()-1);
    }
}
