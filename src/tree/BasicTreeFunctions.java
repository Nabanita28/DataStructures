package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BasicTreeFunctions {
    static Node root;
    static Node temp = root;
    public static void main(String[] args) {
            root = new Node(10);
            root.left = new Node(9);
            root.left.left = new Node(8);
            root.right = new Node(7);
            root.right.right = new Node(6);
        System.out.println("Before Insertion : ");
            inorder(root);
            insert(root, 12);
        System.out.println("After Insertion : ");
            inorder(root);
    }

    static class Node{
        int key;
        Node left, right;

        Node(int key){
            this.key = key;
            left = null;
            right = null;
        }
    }

    static void inorder(Node temp) {
        if (temp == null) {
            return;
        }
            inorder(temp.left);
            System.out.println(temp.key);
            inorder(temp.right);
        }

    static void insert(Node temp, int key){
        Queue<Node> q = new LinkedList<>();
        q.add(temp);
        while(!q.isEmpty()){
            temp = q.peek();
            q.remove();

            if(temp.right == null){
                temp.right = new Node(key);
                break;
            } else{
                q.add(temp.right);
            }
            if (temp.left == null) {
                temp.left = new Node(key);
                break;
            }  else{
                q.add(temp.left);
            }

        }
    }
}
