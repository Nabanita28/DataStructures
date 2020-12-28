package dataStructuresPractice.tree;

public class TreeNode {

    public TreeNode left;
    public int key;
    public TreeNode right;
    public TreeNode root;
    public int hd;
    public TreeNode nextRight;
    public int vd;

    public TreeNode(int key){
        this.key = key;
        this.left = null;
        this.right = null;
        this.hd = this.vd = 0;
        this.nextRight = null;
    }
}
