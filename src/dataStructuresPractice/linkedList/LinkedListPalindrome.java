package dataStructuresPractice.linkedList;

import java.util.Stack;

public class LinkedListPalindrome {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        Node firstNode = new Node("a");
        Node secondNode = new Node("b");
        Node thirdNode = new Node("c");
        Node fourthNode = new Node("x");
        Node fifthNode = new Node("e");
        list.head = firstNode;
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
        fourthNode.next = fifthNode;
        list.printDataInList(list.head);
        System.out.println(isPalindrome(list.head));
    }

    public static boolean isPalindrome(Node head){
        Node n = head;
        boolean result = true;
        Stack<String> stack = new Stack();
        while(n != null){
            stack.push(n.input);
            n = n.next;
        }
        n = head;
        while(n != null){
            if(n.input.equalsIgnoreCase(stack.pop())) {
                result = true;
                n = n.next;
            }
            else{
                result = false;
                break;
            }
        }
        return result;
    }

}
