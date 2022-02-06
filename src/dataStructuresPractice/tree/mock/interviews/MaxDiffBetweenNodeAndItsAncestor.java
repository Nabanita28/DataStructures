package dataStructuresPractice.tree.mock.interviews;

import dataStructuresPractice.tree.TreeNode;

public class MaxDiffBetweenNodeAndItsAncestor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);

        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);

        root.right = new TreeNode(10);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);
        System.out.println("Maximum difference between a node and its ancestor is : " + maxDiff(root));

    }
 /*   If we are at leaf node then just return its value because it can’t be ancestor of any node.
  Then at each internal node we will try to get minimum value from left subtree and right subtree
  and calculate the difference between node value and this minimum value and according to that we will update the result.
    As we are calculating minimum value while retuning in recurrence we will check all optimal possibilities
     (checking node value with minimum subtree value only) of differences and hence calculate the result in one traversal only.
   */
 static int maxDiff(TreeNode root)
    {
        maxDiffUtil(root);
        return max;
    }

    static int max = Integer.MIN_VALUE;

    static int maxDiffUtil(TreeNode root){

        if(root == null){
            return Integer.MAX_VALUE;
        }

        if(root.left == null && root.right == null){
            return root.key;
        }

        int min_node_value = Math.min(maxDiffUtil(root.left), maxDiffUtil(root.right));

        max = Math.max(max, root.key - min_node_value);
        /* Returning minimum value got so far */
        return Math.min(min_node_value, root.key);
    }
}
