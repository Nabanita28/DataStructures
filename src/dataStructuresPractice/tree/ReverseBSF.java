package dataStructuresPractice.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseBSF {
    public static void main(String[] args) {
        TreeNode root = BasicTreeFunctions.createTree();
        System.out.println("Using dataStructuresPractice.recursion ");
        BasicTreeFunctions.inorder(root);
        System.out.println("BFS reverse traversal");
        reverseBFS(root);
    }

    private static void reverseBFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp;
        queue.add(root);
        stack.push(root);
        while(!queue.isEmpty()){
            temp = queue.remove();
            if (temp.left != null)
            queue.add(temp.left);
            if(temp.right != null)
            queue.add(temp.right);

            if(temp.right != null)
                stack.push(temp.right);
            if (temp.left != null)
                stack.push(temp.left);

        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop().key + " ");
        }
    }
}
