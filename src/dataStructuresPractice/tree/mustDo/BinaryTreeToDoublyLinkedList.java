package dataStructuresPractice.tree.mustDo;

import dataStructuresPractice.tree.TreeNode;

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
    private static void binaryToDoublyLinkedList(TreeNode node) {

        if (node == null)
            return;

        binaryToDoublyLinkedList(node.left);

        if (prev == null){
            //mark node as head
            head = node;
        }
        else{
            node.left = prev;
            prev.right = node;
        }
        prev = node;

        binaryToDoublyLinkedList(node.right);
    }
}
