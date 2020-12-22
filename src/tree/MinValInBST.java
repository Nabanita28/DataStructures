package tree;

public class MinValInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("Min val in a BST - " + minimumValue(root));
        System.out.println("Minimum val in a Binary tree - " + minValueInABinaryTree(root));
        System.out.println("Maximum val in a Binary tree - " + maxValueBinaryTree(root));
    }

    static int maxValueBinaryTree(TreeNode node)
    {

        if(node == null){
            return Integer.MIN_VALUE;
        }

        int max_value = node.key;
        int left = maxValueBinaryTree(node.left);
        int right = maxValueBinaryTree(node.right);

        if(max_value < left){
            max_value = left;
        }
        if(max_value < right){
            max_value = right;
        }
        return max_value;
    }

    static int minimumValue(TreeNode node)
    {
        TreeNode current = node;
        while(current.left != null){
            current = current.left;
        }

        return current.key;
    }

    static int minValueInABinaryTree(TreeNode node){

        if (node == null){
            return Integer.MAX_VALUE;
        }

        int min_value = node.key;
        int left = minValueInABinaryTree(node.left);
        int right = minValueInABinaryTree(node.right);

        if (left < min_value){
            min_value = left;
        }

        if(right < min_value){
            min_value = right;
        }

        return min_value;
    }
}
