package dataStructuresPractice.tree;

public class TreeDepth {
    public static void main(String[] args) {
        TreeNode root = BasicTreeFunctions.createTree();
        System.out.println("Using dataStructuresPractice.recursion ");
        BasicTreeFunctions.inorder(root);
        System.out.println("Depth of a dataStructuresPractice.tree " + maxDepth(root));
    }

    private static int maxDepth(TreeNode node) {

        if(node == null) return 0;
        else{
            int leftDepth = maxDepth(node.left);
            int rightDepth = maxDepth(node.right);
            if(leftDepth > rightDepth)

                return leftDepth+1;
            else
                return rightDepth+1;
        }

    }
}
