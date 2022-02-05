package dataStructuresPractice.bfsTraversal;

import dataStructuresPractice.tree.TreeNode;

public class PathWithGivenSequence {
    public static void main(String[] args) {
        int sequence[] = {5, 2, 4, 8};

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.left.right = new TreeNode(7);
        System.out.println(isSequencePresent(root,sequence, 0));
    }

    public static boolean isSequencePresent(TreeNode root, int[] sequence, int index){

        if(root == null){
            return false;
        }

        if(index >= sequence.length || root.key != sequence[index]){
            return false;
        }

        if(root.left == null && root.right == null && index == sequence.length-1){
            return true;
        }

        return isSequencePresent(root.left, sequence, index+1)
               || isSequencePresent(root.right, sequence, index+1);

    }
}
