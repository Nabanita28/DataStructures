package tree.mock.interviews;

import tree.TreeNode;

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

        int dl = findNodesAtkDistanceFromGivenTarget(root.left, target, k);

        if (dl != -1) {
            if (dl == k) {
                System.out.println(root.key);
            } else
                findNodesAtkDistanceFromGivenTargetDown(root.right, k - dl -1);
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
