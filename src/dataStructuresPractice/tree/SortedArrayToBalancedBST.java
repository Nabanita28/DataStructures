package dataStructuresPractice.tree;

public class SortedArrayToBalancedBST {
    public static void main(String[] args) {
        TreeNode root = sortedArrayToBST(new int[]{-10,-3,0,5,9});
        preOrder(root);
    }

    private static void preOrder(TreeNode node) {

        if (node == null)
            return;

        System.out.print(node.key + " ");

        
        preOrder(node.left);
        preOrder(node.right);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {

        int n = nums.length-1;
        return recur(nums, 0, n);

    }

    private static TreeNode recur(int[] nums, int start, int end){

        if(start > end)
            return null;

        int mid = (start + end)/2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = recur(nums, start, mid-1);
        node.right = recur(nums, mid + 1, end);

        return node;
    }
}
