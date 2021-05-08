package dataStructuresPractice.tree;

import java.util.Stack;

public class PreOderTraversalIterative {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        printPreOrderTraversal(root);
    }
    static void printPreOrderTraversal(TreeNode node){

        if (node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = node;

        while(current != null || !stack.isEmpty()){

            while(current != null){

                System.out.println(current.key);

                if (current.right != null) {
                    stack.push(current.right);
                }
                current = current.left;
            }

            if(!stack.isEmpty()) {
                current = stack.pop();
            }
        }
    }
}
