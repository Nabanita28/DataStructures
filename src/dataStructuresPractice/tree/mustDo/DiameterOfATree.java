package dataStructuresPractice.tree.mustDo;

import dataStructuresPractice.tree.TreeNode;

public class DiameterOfATree {
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
        System.out.println("Diameter of the dataStructuresPractice.tree is : " + findDiameter(root));
    }

    static int max = Integer.MIN_VALUE;

    private static int findDiameter(TreeNode root) {
        calculateDiameter(root);
        return max;
    }

    private static int calculateDiameter(TreeNode root){

        //base case
        if(root == null){
            return 0;
        }

        int leftHeight = calculateDiameter(root.left);
        int rightHeight = calculateDiameter(root.right);

        max = Math.max(max, leftHeight+rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);

    }
}
