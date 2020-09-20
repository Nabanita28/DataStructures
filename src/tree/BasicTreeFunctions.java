package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BasicTreeFunctions {
    static TreeNode root;
    static TreeNode temp = root;
    public static void main(String[] args) {
        createTree();
        System.out.println("Before Insertion : ");
            inorder(root);
            insert(root, 12);
        System.out.println("After Insertion : ");
            inorder(root);
    }

    public static TreeNode createTree() {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);
        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(13);
        root.right.right.left = new TreeNode(14);
        root.right.right.right = new TreeNode(15);
        root.left.right.left.left = new TreeNode(16);
        root.left.right.left.right = new TreeNode(17);
        root.right.left.right.left = new TreeNode(18);
        root.right.right.left.right = new TreeNode(19);

        return root;
    }


    static void inorder(TreeNode temp) {
        if (temp == null) {
            return;
        }
            inorder(temp.left);
            System.out.println(temp.key);
            inorder(temp.right);
        }

    static void insert(TreeNode temp, int key){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(temp);
        while(!q.isEmpty()){
            temp = q.peek();
            q.remove();

            if(temp.left == null){
                temp.left = new TreeNode(key);
                break;
            } else{
                q.add(temp.left);
            }

            if(temp.right == null){
                temp.right = new TreeNode(key);
                break;
            } else{
                q.add(temp.right);
            }
        }
    }

    private static void deleteNode(int key){
        TreeNode n = root;
        int tempData = 0;
        TreeNode nodeToBeDeleted;
        while (temp.right != null){
             tempData = temp.key;
            nodeToBeDeleted = temp;

        }
        while(n != null){
            if(n.key == key) {
                n.key = tempData;
                break;
            }
        }
        nodeToBeDeleted = null;
    }

}
