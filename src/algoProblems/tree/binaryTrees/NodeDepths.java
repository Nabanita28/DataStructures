package algoProblems.tree.binaryTrees;

import dataStructuresPractice.tree.TreeNode;
//Given a Binary Tree and a key, write a function that returns level of the key.  If the input key is 3, then your function should return 1.
public class NodeDepths {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left    = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.right   = new TreeNode(5);
        root.left.right = new TreeNode(4);

        for (int i=1; i<=5; i++){
            System.out.println("The level of node " + i + " is " + findNodeDepths(root, i));
        }

    }

    private static int findNodeDepths(TreeNode root, int data) {
        return findNodeDepthsUtil(root, data, 1);
    }

    private static int findNodeDepthsUtil(TreeNode root, int data, int level) {

        if(root == null){
            return 0;
        }

        if(root.key == data){
            return level;
        }

        int downLevel = findNodeDepthsUtil(root.left, data, level+1);
        if (downLevel != 0){
            return downLevel;
        }

        downLevel = findNodeDepthsUtil(root.right, data, level+1);
        return downLevel;
    }
}
