package algoProblems.tree.binaryTrees;

import dataStructuresPractice.tree.TreeNode;

public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(9);
        root.left = new TreeNode(4);
        root.right = new TreeNode(17);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(6);
        printInOrder(root);
        System.out.println();
        invertTree(root);
        printInOrder(root);
    }

    public static TreeNode invertTree(TreeNode root) {

        if (root == null)
            return root;

        /* recursive calls */
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        /* swap the left and right pointers */
        root.left = right;
        root.right = left;

        return root;

    }

    static void printInOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        printInOrder(root.left);
        System.out.print(root.key + " ");
        printInOrder(root.right);
    }
}
