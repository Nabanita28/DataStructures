package dataStructuresPractice.tree.mustDo;

import dataStructuresPractice.tree.TreeNode;

public class IdenticalTrees {
    public static void main(String[] args) {
        TreeNode rootA = new TreeNode(1);
        rootA.left = new TreeNode(2);
        rootA.right = new TreeNode(3);

        TreeNode rootB = new TreeNode(1);
        rootB.left = new TreeNode(2);
        rootB.right = new TreeNode(3);

        System.out.println("Are the given 2 trees identical ? - " + checkIfIdentical(rootA, rootB));
    }

    private static boolean checkIfIdentical(TreeNode rootA, TreeNode rootB) {

        if (rootA == null && rootB == null)
            return true;

            return (rootA.key == rootB.key && checkIfIdentical(rootA.left, rootB.left) && checkIfIdentical(rootA.right, rootB.right));

    }
}
