package dataStructuresPractice.tree;

public class ChildrenSumProperty {
    public static void main(String[] args) {
        TreeNode root = BasicTreeFunctions.createTree();
        System.out.println("Using dataStructuresPractice.recursion ");
        BasicTreeFunctions.inorder(root);
        System.out.println("BFS traversal");
        System.out.println(isChildrenSumProperty(root));
    }

    private static boolean isChildrenSumProperty(TreeNode node) {

        if(node == null || (node.left == null && node.right == null))
            return true;

        int left_data = node.left != null ? node.left.key : 0;
        int right_data = node.right != null ? node.right.key : 0;
        boolean isCurrentValueValid = (node.key == left_data + right_data);

        if(isCurrentValueValid)
            return isChildrenSumProperty(node.left) && isChildrenSumProperty(node.right);
        else
            return false;

    }
}
