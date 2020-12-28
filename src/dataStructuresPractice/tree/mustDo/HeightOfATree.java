package dataStructuresPractice.tree.mustDo;

import dataStructuresPractice.tree.TreeNode;

public class HeightOfATree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.right = new TreeNode(9);
        System.out.println("Height of the dataStructuresPractice.tree is : " + findHeight(root));
    }

    private static int findHeight(TreeNode root) {

        if (root == null)
            return 0;

        int left_height = findHeight(root.left);
        int right_height = findHeight(root.right);

        return 1 + Math.max(left_height, right_height);
    }
}
