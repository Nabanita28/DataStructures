package tree.mock.interviews;

import tree.BasicTreeFunctions;
import tree.TreeNode;

public class MaxDiffBetweenNodeAndItsAncestor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);

        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);

        root.right = new TreeNode(10);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);
        System.out.println("Maximum difference between a node and its ancestor is : " + maxDiff(root));

    }

    static int maxDiff(TreeNode root)
    {
        Res res = new Res();
        maxDiffUtil(root, res);
        return res.r;
    }

    static class Res{
        int r = Integer.MIN_VALUE;
    }

    static int maxDiffUtil(TreeNode root, Res res){

        if(root == null){
            return Integer.MAX_VALUE;
        }

        if(root.left == null && root.right == null){
            return root.key;
        }

        int min_node_value = Math.min(maxDiffUtil(root.left, res), maxDiffUtil(root.right, res));

        res.r = Math.max(res.r, root.key - min_node_value);

        return Math.min(min_node_value, root.key);
    }
}
