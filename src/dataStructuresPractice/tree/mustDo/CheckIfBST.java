package dataStructuresPractice.tree.mustDo;

import dataStructuresPractice.tree.TreeNode;

public class CheckIfBST {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);


          /* root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);*/

        System.out.println(checkIfBST(root));
    }

    static public boolean checkIfBST(TreeNode root) {
        return isBSTUtil(root, null, null);
    }

    static boolean isBSTUtil(TreeNode root, Integer min, Integer max){

        if(root == null){
            return true;
        }

        if((min != null && root.key <= min) || (max != null && root.key >= max)){
            return false;
        }

        return isBSTUtil(root.left, min, root.key) && isBSTUtil(root.right, root.key, max);
    }

}
