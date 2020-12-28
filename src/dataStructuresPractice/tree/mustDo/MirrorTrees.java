package dataStructuresPractice.tree.mustDo;

import dataStructuresPractice.tree.TreeNode;

public class MirrorTrees {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(4);

        /*root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);*/


        System.out.println(checkIfMirrorTrees(root.left, root.right));
    }

    private static boolean checkIfMirrorTrees(TreeNode nodeA, TreeNode nodeB) {

        if (nodeA == null && nodeB == null)
            return true;

        if (nodeA != null && nodeB != null)
            return (nodeA.key == nodeB.key  && checkIfMirrorTrees(nodeA.left, nodeB.right)
                                            && checkIfMirrorTrees(nodeA.right, nodeB.left));

        return false;
    }
}
