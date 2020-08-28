package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        TreeNode root = BasicTreeFunctions.createTree();
        System.out.println("Using recursion ");
        BasicTreeFunctions.inorder(root);
        System.out.println("BFS traversal");
        bfsTraversal(root);
    }

    private static void bfsTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode current;
        queue.add(root);
        while(!queue.isEmpty()){
            current = queue.remove();
            System.out.println(current.key);

            if(current.left != null)
                queue.add(current.left);
            if(current.right != null)
                queue.add(current.right);

        }
    }


}
