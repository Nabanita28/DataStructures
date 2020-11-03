package tree;

import java.util.LinkedList;
import java.util.Queue;

public class ParentNodesSum {
    public static void main(String[] args) {
        TreeNode root = BasicTreeFunctions.createTree();
        System.out.println("Using recursion ");
        BasicTreeFunctions.inorder(root);
        System.out.println("Sum of parent nodes of node 2 : " + sumOfParentNodes(root, 2));
    }

    private static int sumOfParentNodes(TreeNode root, int value) {
        TreeNode node ;
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {

                node = queue.remove();
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
            if (node.left != null && node.left.key == value)
                sum += node.key;
            if (node.right != null && node.right.key == value)
                sum += node.key;
        }

        return  sum;
    }
}
