package dataStructuresPractice.tree;

import java.util.Stack;

public class InorderTraversal {
    public static void main(String[] args) {
        TreeNode root = BasicTreeFunctions.createTree();
        System.out.println("Using dataStructuresPractice.recursion ");
        BasicTreeFunctions.inorder(root);
        System.out.println("Using dataStructuresPractice.recursion ");
        inorderUsingStack(root);
        System.out.println("Using dataStructuresPractice.recursion 2");
        inorderUsingStack2(root);
    }

    private static void inorderUsingStack(TreeNode root) {

        Stack<TreeNode> s = new Stack();
        TreeNode current = root;

        while(current != null){
            s.push(current);
            current = current.left;
        }

        while(current == null && !s.isEmpty()){
            TreeNode temp = s.pop();
            System.out.println(temp.key);
            current = temp.right;
            while(current != null){
                s.push(current);
                current = current.left;
            }
        }
        if(current == null && s.isEmpty())
            return;


    }

    private static void inorderUsingStack2(TreeNode root) {

        Stack<TreeNode> s = new Stack();
        TreeNode current = root;

        do{
            while(current != null){
                s.push(current);
                current = current.left;
            }

            if(!s.isEmpty()){
                TreeNode temp = s.pop();
                System.out.println(temp.key);
                current = temp.right;
            }
        } while(current != null || !s.isEmpty());

    }
}
