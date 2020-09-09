package tree;

public class TreeSumAllNodes{

    public static void main(String[] args) {

        TreeNode root = BasicTreeFunctions.createTree();
        System.out.println("Using recursion ");
        BasicTreeFunctions.inorder(root);
        System.out.println("Sum of all the nodes in a tree : " + sumOfAllNodes(root));
    }

    private static int sumOfAllNodes(TreeNode root) {
        if(root == null) return 0;
        return sumOfAllNodes(root.left) + root.key + sumOfAllNodes(root.right);
    }
}
