package tree.mustDo;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CreateMirror {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(60);
        root.right = new TreeNode(30);
        inOrder(root);
        mirror(root);
        System.out.println();
        inOrder(root);
    }

    static void mirror(TreeNode node){

            if(node == null){
                return;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(node);

            while(!queue.isEmpty()){
                TreeNode curr = queue.remove();

                TreeNode temp = curr.left;
                curr.left = curr.right;
                curr.right = temp;

                if(curr.left != null){
                    queue.add(curr.left);

                }
                if(curr.right != null){
                    queue.add(curr.right);

                }
            }

        }

        public static void inOrder(TreeNode node){
            if (node == null)
                return;

            inOrder(node.left);
            System.out.print(node.key +" ");
            inOrder(node.right);
        }


}
