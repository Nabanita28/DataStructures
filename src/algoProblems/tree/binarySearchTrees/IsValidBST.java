package algoProblems.tree.binarySearchTrees;

import dataStructuresPractice.tree.TreeNode;

public class IsValidBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        System.out.println(isValidBST(root));
    }
    public static boolean isValidBST(TreeNode root) {

        return isBSTUtil(root, null, null);
    }

    static boolean isBSTUtil(TreeNode root, TreeNode left, TreeNode right){

        if(root == null){
            return true;
        }

        if(left != null && root.key <= left.key){
            return false;
        }

        if(right != null && root.key >= right.key){
            return false;
        }

        return isBSTUtil(root.left, left, root) && isBSTUtil(root.right, root, right);
    }
}
