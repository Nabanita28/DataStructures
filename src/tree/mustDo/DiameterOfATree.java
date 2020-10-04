package tree.mustDo;

import tree.TreeNode;

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
        System.out.println("Diameter of the tree is : " + findDiameter(root));
    }

    static class Height{
        int h = Integer.MIN_VALUE;
    }

    private static int findDiameter(TreeNode root) {
        Height height = new Height();
        diameter(root, height);
        return height.h;
    }

    private static int diameter(TreeNode root, Height height) {

        if (root == null){
            height.h = 0;
            return 0;
        }

        int left_height = diameter(root.left, height);
        int right_height = diameter(root.right, height);

        height.h = Math.max(height.h, left_height+right_height+1);
        return 1 + Math.max(left_height, right_height);
    }
}
