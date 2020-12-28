package dataStructuresPractice.tree.mock.interviews;

import dataStructuresPractice.tree.TreeNode;

public class FindNodesAtKDistance {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        TreeNode target = root.left.right;
        System.out.println("Nodes At K Distance from target is : ");
        findNodesAtkDistanceFromGivenTarget(root, target, 2);
    }

    private static int findNodesAtkDistanceFromGivenTarget(TreeNode root, TreeNode target, int k) {
        if (root == null)
            return -1;

        if (root == target) {
            findNodesAtkDistanceFromGivenTargetDown(root, k);
            return 1;
        }
        // Recur for left subtree
        int dl = findNodesAtkDistanceFromGivenTarget(root.left, target, k);
        // Check if target node was found in left subtree
        if (dl != -1) {

            // If root is at distance k from target, print root
            // Note that dl is Distance of root's left child from
            // target
            if (dl == k) {
                System.out.println(root.key);
            } else
                // Else go to right subtree and print all k-dl-1 distant nodes
                // Note that the right child is 2 edges away from left child
                findNodesAtkDistanceFromGivenTargetDown(root.right, k - dl -1);
            // Add 1 to the distance and return value for parent calls
            return dl + 1;
        }

        int dr = findNodesAtkDistanceFromGivenTarget(root.right, target, k);

        if (dr != -1) {

            if (dr == k) {
                System.out.println(root.key);
            } else
                findNodesAtkDistanceFromGivenTargetDown(root.left, k - dr -1);

            return dr + 1;
        }
    return -1;
    }

    private static void findNodesAtkDistanceFromGivenTargetDown(TreeNode node, int k) {

        if (node == null) {
            return;
        }

        if (k == 0) {
            System.out.println(node.key);
            return;
        }

        findNodesAtkDistanceFromGivenTargetDown(node.left, k - 1);
        findNodesAtkDistanceFromGivenTargetDown(node.right, k - 1);
    }
}
