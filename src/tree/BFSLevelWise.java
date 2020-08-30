package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BFSLevelWise {
    public static void main(String[] args) {
        TreeNode root = BasicTreeFunctions.createTree();
        System.out.println("Using recursion ");
        BasicTreeFunctions.inorder(root);
        System.out.println("BFS traversal");
        bfsLevelWiseTraversal(root);
    }

    private static void bfsLevelWiseTraversal(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode separator = new TreeNode(0);

        queue.add(root);
        queue.add(separator);

        TreeNode current;

        while(!queue.isEmpty()){

            current = queue.remove();

            if(current == separator){
                System.out.println();
                if(!queue.isEmpty())
                queue.add(separator);
            }
            else {
                System.out.print(current.key);

                if (current.left != null && current.left.key != 0)
                    queue.add(current.left);
                if (current.right != null && current.right.key != 0)
                    queue.add(current.right);
            }
        }
    }
}
