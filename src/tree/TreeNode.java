package tree;

public class TreeNode {

    public TreeNode left;
    public int key;
    public TreeNode right;
    public TreeNode root;
    public int hd;

    public TreeNode(int key){
        this.key = key;
        this.left = null;
        this.right = null;
        this.hd = 0;
    }
}
