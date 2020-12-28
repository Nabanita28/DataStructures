package dataStructuresPractice.tree.mock.interviews;

import dataStructuresPractice.tree.TreeNode;

import java.util.Stack;

public class PreOrderToPostOrder {
    public static void main(String[] args) {
        int[] arr  = new int[]{40,30,35,80,100};
        TreeNode root = constructTree(arr, arr.length);
        inorder(root);
    }

    private static void inorder(TreeNode root) {

        if(root == null){
            return;
        }

        inorder(root.left);
        System.out.println(root.key);
        inorder(root.right);
    }

    public static TreeNode constructTree(int pre[], int size) {

        Stack<TreeNode> stack = new Stack<>();

        TreeNode root = new TreeNode(pre[0]);

        stack.push(root);

        for(int i=1; i<size; i++){

            TreeNode temp = null;

             /* Keep on popping while the next value is greater than
             dataStructuresPractice.stack's top value. */
            while(!stack.isEmpty() && pre[i] > stack.peek().key){
                temp = stack.pop();
            }
            //Make this greater value as the right child and push it to the dataStructuresPractice.stack
            if(temp != null){
                temp.right = new TreeNode(pre[i]);
                stack.push(temp.right);
            }
            // If the next value is less than the dataStructuresPractice.stack's top value, make this value as the left child of the
            // dataStructuresPractice.stack's top node. Push the new node to dataStructuresPractice.stack
            else{
                temp = stack.peek();
                temp.left = new TreeNode(pre[i]);
                stack.push(temp.left);
            }
        }
        return root;
    }
}
