package algoProblems.tree.binarySearchTrees;

import dataStructuresPractice.tree.TreeNode;

public class ClosestValueInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(9);
        root.left    = new TreeNode(4);
        root.right   = new TreeNode(17);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(5);
        root.left.right.right = new TreeNode(7);
        root.right.right = new TreeNode(22);
        root.right.right.left = new TreeNode(20);
        System.out.println("Closest Value In BST for the given key is " + findClosestValueInBST(root, 19));
    }

    static int min_diff = Integer.MAX_VALUE;
    static int min_diff_key = 0;

    private static int findClosestValueInBST(TreeNode root, int key) {

        findClosestValueInBSTRecur(root, key);
        return min_diff_key;

    }

    private static void findClosestValueInBSTRecur(TreeNode root, int key) {

        if (root == null){
            return;
        }

        if (root.key == key){
            min_diff_key = key;
            return;
        }

        //update min_diff and min_diff_key
        if (min_diff > Math.abs(key - root.key)){
            min_diff = Math.abs(key - root.key);
            min_diff_key = root.key;
        }
        //if key is less than root.key, then move left else move right
        if (key < root.key){
            findClosestValueInBSTRecur(root.left, key);
        }
        findClosestValueInBSTRecur(root.right, key);
    }
}
