package dataStructuresPractice.tree;

public class LCA {
    public static void main(String[] args) {
        TreeNode root = BasicTreeFunctions.createTree();
        System.out.println("Using dataStructuresPractice.recursion ");
        BasicTreeFunctions.inorder(root);
        System.out.println("LCA : " + lca(root, 4,6).key);
    }

    private static TreeNode lca(TreeNode root, int n1, int n2) {
        TreeNode node = root;
        if(node == null) return null;

        if(n1 == node.key || n2 == node.key)
            return node;

        TreeNode leftTreeLCA = lca(node.left, n1, n2);
        TreeNode rightTreeLCA = lca(node.right, n1, n2);


        if(leftTreeLCA != null && rightTreeLCA != null){
            return node;
        }
        else{
           return leftTreeLCA != null ? leftTreeLCA : rightTreeLCA;
        }
    }
}
