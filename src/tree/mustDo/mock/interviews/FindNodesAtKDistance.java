package tree.mustDo.mock.interviews;

import tree.TreeNode;

public class FindNodesAtKDistance {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(25);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        findNodesAtkDistanceFromGivenTarget(root, 8, 2);
    }

    private static void findNodesAtkDistanceFromGivenTarget(TreeNode root, int target, int k) {

    }

    private static void findNodesAtkDistanceFromGivenTargetDown(TreeNode node, int k) {

        if (node == null){
            return;
        }

        if (k==0){
            System.out.println(node.key);
        }


    }
}
