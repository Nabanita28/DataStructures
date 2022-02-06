package dataStructuresPractice.tree;

public class FindKthSmallestInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println(kthSmallest2(root, 3).key);
    }

    static int count = 0;

    private static TreeNode kthSmallest(TreeNode root, int k) {

        if (root == null) {
            return null;
        }
        TreeNode left = kthSmallest(root.left, k);

        if (left != null) {
            return left;
        }
        count++;
        if (count == k) {
            return root;
        }
        return kthSmallest(root.right, k);
    }


    private static TreeNode kthSmallest2(TreeNode root, int k) {

        if (root == null) {
            return root;
        }

        kthSmallest2(root.left, k);
        count++;
        if (count == k) {
            return root;
        }
        return kthSmallest2(root.right, k);
    }
}