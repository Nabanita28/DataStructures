package dataStructuresPractice.linkedList.mock.interviews;

import dataStructuresPractice.linkedList.LinkedList;
import dataStructuresPractice.linkedList.Node;

public class MergeSortForLinkedList {
    public static void main(String[] args) {
        Node firstNode = new Node(40);
        Node secondNode = new Node(20);
        Node thirdNode = new Node(60);
        Node fourthNode = new Node(10);
        Node fifthNode = new Node(50);
        Node sixthNode = new Node(30);
        Node head = firstNode;
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
        fourthNode.next = fifthNode;
        fifthNode.next = sixthNode;
        Node mergedLinkedList = mergeSort(head);
        LinkedList.printList(mergedLinkedList);

    }
    static Node mergeSort(Node head)
    {

        //base case
        if (head == null || head.next == null){
            return head;
        }
        Node middleNode = findMiddle(head);
        Node nextOfMiddle = middleNode.next;
        middleNode.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(nextOfMiddle);

        Node sortedList = sortMergeList(left, right);

        return sortedList;
    }

    static Node findMiddle(Node node){

        if (node == null)
            return node;

        Node slowPointer = node;
        Node fastPointer = node;

        while(fastPointer.next != null && fastPointer.next.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        return slowPointer;
    }

    static Node sortMergeList(Node left, Node right){

        Node dummy = new Node(0);
        Node tail = dummy;

        while(true){

            if (left == null){
                tail.next = right;
                break;
            }

            if (right == null){
                tail.next = left;
                break;
            }

            if(left.data <= right.data){
                tail.next = left;
                left = left.next;
            }else{
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }
        return dummy.next;

    }
    static Node sortMergeListRecur(Node left, Node right){

        Node result = null;

        if(left == null) return right;

        if(right == null) return left;

        if(left.data <= right.data){
            result = left;
            result.next = sortMergeListRecur(left.next, right);
        }else{
            result = right;
            result.next = sortMergeListRecur(left, right.next);
        }

        return result;
    }
}
