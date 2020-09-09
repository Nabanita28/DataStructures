package tree;

import java.util.LinkedList;
import java.util.Queue;

public class LeftLeavesSum {

    public static void main(String[] args) {
        TreeNode root = BasicTreeFunctions.createTree();
        System.out.println("Using recursion ");
        BasicTreeFunctions.inorder(root);
        System.out.println("Sum of left leaf nodes : " + sumOfLeftLeaves(root));
    }

    private static int sumOfLeftLeaves(TreeNode root) {
        TreeNode node ;
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            node = queue.remove();

            if(isLeafNode(node.left))
                sum += node.left.key;

            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }

        return sum;
    }

    private static boolean isLeafNode(TreeNode node) {
        if (node == null) return false;
        return node.left == null && node.right == null;
    }

}
