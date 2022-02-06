package dataStructuresPractice.tree.mustDo;

import dataStructuresPractice.tree.TreeNode;

public class BinaryTreeToDoublyLinkedList {

    static class Tree {
        TreeNode root;

        Tree() {
            root = null;
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.root = new TreeNode(10);
        tree.root.left = new TreeNode(12);
        tree.root.right = new TreeNode(15);
        tree.root.left.left = new TreeNode(25);
        tree.root.left.right = new TreeNode(30);
        tree.root.right.left = new TreeNode(36);

        System.out.println("Binary Tree To Doubly Linked List");
        binaryToDoublyLinkedList(tree.root);
        //TreeNode node = BSTtoCircularDLL(tree.root);
        print();
    }

    private static TreeNode BSTtoCircularDLL(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode left = BSTtoCircularDLL(root.left);
        TreeNode right = BSTtoCircularDLL(root.right);

        root.left = root;
        root.right = root;

        return concatenate(concatenate(left, root), right);

    }

    static TreeNode concatenate(TreeNode leftList, TreeNode rightList) {
        if (leftList == null) {
            return rightList;
        }
        if (rightList == null) {
            return leftList;
        }

        TreeNode leftLastNode = leftList.left;
        TreeNode rightLastNode = rightList.left;

        leftLastNode.right = rightList;
        rightList.left = leftLastNode;

        leftList.left = rightLastNode;
        rightLastNode.right = leftList;
        return leftList;

    }

    private static void print() {
        while (head != null) {
            System.out.print(head.key + " ");
            head = head.right;
        }
    }

    static public void print(TreeNode head) {
        System.out.println("Circular Linked List is :");
        TreeNode current = head;
        while (current.right != head) {
            System.out.print(current.key + " ");
            current = current.right;
        }
        System.out.println();
    }

    static TreeNode prev = null;
    static TreeNode head;

    private static void binaryToDoublyLinkedList(TreeNode node) {

        if (node == null)
            return;

        binaryToDoublyLinkedList(node.left);

        if (prev == null) {
            //mark node as head
            head = node;
        } else {
            node.left = prev;
            prev.right = node;
        }
        prev = node;

        binaryToDoublyLinkedList(node.right);
    }
}
