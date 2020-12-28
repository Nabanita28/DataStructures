package dataStructuresPractice.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BFSwithoutSibling {
    //TODO - revise
    public static void main(String[] args) {
        TreeNode root = BasicTreeFunctions.createTree();
        System.out.println("BFS without Sibling");
        bfsWithoutSibling(root, 10);

    }

    //print same level nodes without the sibling
    private static void bfsWithoutSibling(TreeNode root, int value) {

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(root);
        TreeNode parent = null;

        if(root.key == value)
            System.out.println(q1.remove() + "value is root");

        while(!q1.isEmpty() || !q2.isEmpty()){

            while(!q1.isEmpty()) {
                TreeNode temp = q1.remove();
                    if ((temp.left != null && temp.left.key == value) || (temp.right != null && temp.right.key == value)) {
                        parent = temp;
                        continue;
                    }

                    if (temp.left != null)
                        q2.add(temp.left);
                    if (temp.right != null)
                        q2.add(temp.right);
                }


            if (parent != null) {
                while (!q2.isEmpty())
                System.out.println(q2.remove().key);
            }

            while(!q2.isEmpty()){
                TreeNode temp = q2.remove();
                    if ((temp.left != null &&temp.left.key == value) || (temp.right !=null &&temp.right.key == value)){
                        parent = temp;
                        continue;
                }

                if(temp.left != null)
                    q1.add(temp.left);
                if(temp.right != null)
                    q1.add(temp.right);
            }

            if (parent != null) {
                while (!q1.isEmpty())
                    System.out.println(q1.remove().key);
            }
        }
    }
}
