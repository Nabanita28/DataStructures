package dataStructuresPractice.tree;

import java.util.LinkedList;
import java.util.Queue;

public class DeleteANodeInBinaryTree {
    public static void main(String[] args) {
        TreeNode root = BasicTreeFunctions.createTree();
        System.out.println("Before deletion - ");

        BasicTreeFunctions.inorder(root);
        TreeNode node = deletionBT(root, 11);
        System.out.println("After deletion - ");
        BasicTreeFunctions.inorder(node);
    }

    public static TreeNode deletionBT(TreeNode root, int key) {
        //Write your code here and return the root of the changed tree

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int deepestNodeData = 0;
        TreeNode deepestNode = null;
        while (!queue.isEmpty()) {

            deepestNode = queue.remove();

            if (deepestNode.left != null) {
                queue.add(deepestNode.left);
            }
            if (deepestNode.right != null) {
                queue.add(deepestNode.right);
            }
        }
        deepestNodeData = deepestNode.key;

        queue.add(root);
        while (!queue.isEmpty()) {

            TreeNode current = queue.remove();

            if (current.key == key) {
                current.key = deepestNodeData;
            }
            if (current.left != null) {
                if(current.left == deepestNode){
                    current.left = null;
                    deepestNode = null;
                }else{
                    queue.add(current.left);
                }
            }

            if(current.right == deepestNode){
                current.right = null;
                deepestNode = null;
            }else{
                queue.add(current.right);
            }
        }
        return root;
    }
}
