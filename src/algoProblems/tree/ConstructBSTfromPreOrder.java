package algoProblems.tree;

import dataStructuresPractice.tree.TreeNode;

import java.util.Stack;

import static dataStructuresPractice.tree.mustDo.CreateMirror.inOrder;

public class ConstructBSTfromPreOrder {
    public static void main(String[] args) {
        int[] preOrder = {10, 5, 1, 7, 40, 50};
        TreeNode root = constructBST(preOrder);
        printInorder(root);
    }

    private static TreeNode constructBST(int[] preOrder) {
        int size = preOrder.length;

        Stack<TreeNode> stack  = new Stack<>();
        TreeNode root = new TreeNode(preOrder[0]);
        stack.push(root);

        for(int i=1; i<size; i++){

            TreeNode current = null;
            while(!stack.isEmpty() && preOrder[i] > stack.peek().key){
                current = stack.pop();
            }

            if(current != null){
                current.right = new TreeNode(preOrder[i]);
                stack.push(current.right);
            } else{
                current = stack.peek();
                current.left = new TreeNode(preOrder[i]);
                stack.push(current.left);
            }
        }
            return root;
    }

    static void printInorder(TreeNode node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.key + " ");
        printInorder(node.right);
    }
}
