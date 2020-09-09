package tree;

public class SumTree {
    public static void main(String[] args) {
        TreeNode root = BasicTreeFunctions.createTree();
        System.out.println("Using recursion ");
        BasicTreeFunctions.inorder(root);
        System.out.println("isSumTree");
        if(isSumTree(root) == 1)
            System.out.println("true");
        else
            System.out.println("false");
    }

    private static int isSumTree(TreeNode root) {
        TreeNode node = root;
        int left_tree, right_tree = 0;

        if(node == null || (node.left == null && node.right == null)){
            return 1;
        }

        left_tree = sum(node.left);
        right_tree = sum(node.right);

        if( root.key == (left_tree + right_tree) && isSumTree(node.left) != 0
                                                && isSumTree(node.right) != 0)
            return 1;

            return 0;
    }

    private static int sum(TreeNode node){
        if (node == null ) return 0;
        return sum(node.left) + node.key + sum(node.right);
    }
}
