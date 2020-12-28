package dataStructuresPractice.tree.mock.interviews;

import dataStructuresPractice.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumInALevel {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(25);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        maximumInALevel(root);
        System.out.println();
        minimumInALevel(root);

    }

    private static void minimumInALevel(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int size = 0;
        int level = 0;
        int min = Integer.MAX_VALUE;
        queue.add(root);

        while(!queue.isEmpty()){
            size = queue.size();
            for (int i=0; i<size; i++){
                TreeNode current = queue.remove();

                if (current.key < min)
                    min = current.key;

                if (current.left != null)
                    queue.add(current.left);

                if (current.right != null)
                    queue.add(current.right);

            }

            level++;
            System.out.println("Min for level : " + level + " is : " + min);
            min = Integer.MAX_VALUE;
        }
    }

    private static void maximumInALevel(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        int size = 0;
        int max = Integer.MIN_VALUE;
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()){
            size = queue.size();

            for (int i=0; i<size; i++){
                TreeNode current = queue.remove();
                if (current.key > max)
                    max = current.key;

                if (current.left != null)
                    queue.add(current.left);

                if (current.right != null)
                    queue.add(current.right);

            }
            level++;
            System.out.println("Max for level : " + level + " is " + max);
            max = Integer.MIN_VALUE;
        }
    }
}
