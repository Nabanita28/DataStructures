package dataStructuresPractice.tree.mustDo;

import dataStructuresPractice.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodesAtSameLevel {

    // easy solution https://www.geeksforgeeks.org/connect-nodes-level-level-order-traversal/
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(90);
        connect(root);
        //fillNextSibling(root);
        System.out.println(root.left.nextRight.key);
        System.out.print("nextRight of node 3 is ");
        System.out.print(root.left.left.nextRight != null ?
                root.left.left.nextRight.key : -1);
    }

    private static void connect(TreeNode root) {

        if (root == null)
            return;

        root.nextRight = null;
        while (root != null) {
            TreeNode current = root;
            while (current != null) {
                if (current.left != null) {
                    if (current.right != null) {
                        current.left.nextRight = current.right;
                    } else
                        current.left.nextRight = getNextRight(current);
                }
                if (current.right != null)
                    current.right.nextRight = getNextRight(current);

                current = current.nextRight;
            }

            if (root.left != null)
                root = root.left;
            else if (root.right != null)
                root = root.right;
            else
                root = getNextRight(root);
        }
    }

    //get the next right node of the node passed as argument
    private static TreeNode getNextRight(TreeNode node) {
        TreeNode temp = node.nextRight;

        while (temp != null) {
            if (temp.left != null) {
                return temp.left;
            } else if (temp.right != null) {
                return temp.right;
            }
            temp = temp.nextRight;
        }
        return null;
    }

    private static TreeNode fillNextSibling(TreeNode root) {

        Queue<TreeNode> nodesQueue = new LinkedList<>();
        nodesQueue.add(root);
        nodesQueue.add(null);

        while (!nodesQueue.isEmpty()) {
            TreeNode current = nodesQueue.remove();
            if (current == null) {
                if (!nodesQueue.isEmpty()) {
                    nodesQueue.add(null);
                }
            } else {
                if (nodesQueue.peek() != null) {
                    current.nextRight = nodesQueue.peek();
                } else {
                    current.nextRight = null;
                }


                if (current.left != null) {
                    nodesQueue.add(current.left);
                }
                if (current.right != null) {
                    nodesQueue.add(current.right);
                }
            }


        }
        return root;
    }
}
