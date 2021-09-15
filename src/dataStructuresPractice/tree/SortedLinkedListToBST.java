package dataStructuresPractice.tree;

import dataStructuresPractice.linkedList.Node;

public class SortedLinkedListToBST {
    public static void main(String[] args) {
        Node firstNode = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);
        Node fourthNode = new Node(4);
        Node fifthNode = new Node(5);
        Node sixthNode = new Node(6);

        Node head = firstNode;
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
        fourthNode.next = fifthNode;
        fifthNode.next = sixthNode;
        sixthNode.next = thirdNode;

        BasicTreeFunctions.inorder(sortedListToBST(head));
    }

    static public TreeNode sortedListToBST(Node head) {

        if(head == null){
            return null;
        }
        return toBST(head, null);
    }

    static TreeNode toBST(Node head, Node tail){

        Node slow = head;
        Node fast = head;
        if(head == tail){
            return null;
        }

        while(fast != tail && fast.next != tail){
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode node = new TreeNode(slow.data);
        node.left = toBST(head, slow);
        node.right = toBST(slow.next, tail);
        return node;
    }
}
