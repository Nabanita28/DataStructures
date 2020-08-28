package tree;

import java.util.Stack;

public class BFSSpiral {
    public static void main(String[] args) {
        TreeNode root = BasicTreeFunctions.createTree();
        System.out.println("Using recursion ");
        BasicTreeFunctions.inorder(root);
        System.out.println("BFS spiral traversal");
        bfsSpriralTraversal(root);

    }

    private static void bfsSpriralTraversal(TreeNode root) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(root);

        while(!s1.isEmpty() || !s2.isEmpty()){
            while(!s1.isEmpty()){
                TreeNode temp = s1.pop();
                System.out.println(temp.key);
                if(temp.left != null)
                    s2.push(temp.left);
                if(temp.right != null)
                    s2.push(temp.right);

            }

            while(!s2.isEmpty()){
                TreeNode temp = s2.pop();
                System.out.println(temp.key);
                if(temp.right != null)
                    s1.push(temp.right);
                if(temp.left != null)
                    s1.push(temp.left);
            }
        }
    }

}
