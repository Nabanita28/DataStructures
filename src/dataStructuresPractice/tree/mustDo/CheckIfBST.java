package dataStructuresPractice.tree.mustDo;

import dataStructuresPractice.tree.TreeNode;

public class CheckIfBST {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);


          /* root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);*/

        System.out.println(checkIfBST(root));
    }

    private static boolean checkIfBST(TreeNode root) {

        if (root == null)
            return true;

        if (root.left != null && root.left.key > root.key )
            return false;

        if (root.right != null && root.right.key < root.key)
            return false;

        return  checkIfBST(root.left) && checkIfBST(root.right);

    }

}
