package tree.mustDo;

import tree.TreeNode;

public class CreateMirror {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(60);
        root.right = new TreeNode(30);
        mirror(root);
    }

    static void mirror(TreeNode node)
    {

        if(node == null){
            return;
        }

        mirror(node.right);
        System.out.print(node.key + " ");
        mirror(node.left);

    }
}
