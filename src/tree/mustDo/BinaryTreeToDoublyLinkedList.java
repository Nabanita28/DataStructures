package tree.mustDo;

import tree.TreeNode;

public class BinaryTreeToDoublyLinkedList {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(12);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(30);
        root.right.left = new TreeNode(36);
        System.out.println("Binary Tree To Doubly Linked List");
        binaryToDoublyLinkedList(root);
        print();
    }

    private static void print() {
        while (head != null){
            System.out.print(head.key + " ");
            head = head.right;
        }
    }

    static TreeNode prev = null;
    static TreeNode head;
    private static void binaryToDoublyLinkedList(TreeNode root) {

        if (root == null)
            return;

        binaryToDoublyLinkedList(root.left);

        if (prev == null){
            //mark root as head
            head = root;
        }
        else{
            root.left = prev;
            prev.right = root;
        }
        prev = root;

        binaryToDoublyLinkedList(root.right);
    }
}
