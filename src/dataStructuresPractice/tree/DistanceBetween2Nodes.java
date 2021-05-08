package dataStructuresPractice.tree;

public class DistanceBetween2Nodes {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("Distance between 2 Nodes = " + findDistanceBetweenTwoNodes(root, 4 ,3));
    }

    private static int findDistanceBetweenTwoNodes(TreeNode node, int n1, int n2){

        TreeNode lca = lca(node, n1, n2);

        int left_distance = findLevel(lca, n1, 0);
        int right_distance = findLevel(lca, n2, 0);

        return left_distance + right_distance;
    }

    private static TreeNode lca(TreeNode node, int n1, int n2){
        //base case
        if (node == null){
            return null;
        }

        if (node.key == n1 || node.key == n2){
            return node;
        }

        TreeNode left_lca = lca(node.left, n1, n2);
        TreeNode right_lca = lca(node.right, n1, n2);

        if (left_lca != null && right_lca != null){
            return node;
        }

        return left_lca != null ? left_lca : right_lca;
    }

    //we will return -1 if element is absent
    private static int findLevel(TreeNode node, int value, int level){
        //base case
        if (node == null){
            return -1;
        }

        if (node.key == value){
            return level;
        }

        int left = findLevel(node.left, value, level+1);

        if (left == -1){
            return findLevel(node.right, value, level+1);
        }
        return left;
    }
}
