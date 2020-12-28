package dataStructuresPractice.linkedList.mustDo;


import dataStructuresPractice.linkedList.LinkedListV2;
import dataStructuresPractice.linkedList.Node;

public class IntersectionPointInYShapedLinkedList {

    public static void main(String[] args){

        LinkedListV2 list1 = new LinkedListV2();

        Node firstNode = new Node(10);
        Node secondNode = new Node(20);
        Node thirdNode = new Node(5);
        Node fourthNode = new Node(10);
        Node fifthNode = new Node(15);


        list1.head = firstNode;
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
        fourthNode.next = fifthNode;
        list1.printList(list1.head);

        LinkedListV2 list2 = new LinkedListV2();
        Node seventhNode = new Node(2);
        Node eightNode = new Node(3);
        list2.head = new Node(1);
        list2.head.next = seventhNode;
        seventhNode.next = eightNode;
        eightNode.next = thirdNode;

        list2.printList(list2.head);
        Node intersectionPoint = findIntersectionPoint(list1.head, list2.head);
        System.out.println();
        System.out.println("Intersection point is : " + intersectionPoint.data);
    }

    private static Node findIntersectionPoint(Node head1, Node head2) {

        Node current1 = head1;
        Node temp1 = head1;
        int count1 = 0;

        Node current2 = head2;
        Node temp2 = head2;
        int count2 = 0;

        while(current1 != null){
            current1 = current1.next;
            count1++;
        }

        while(current2 != null){
            current2 = current2.next;
            count2++;
        }

        int diff1 = count1 - count2;
        int diff2 = count2 - count1;

        if (count1  > count2){

            while( diff1 > 0) {
                temp1 = temp1.next;
                diff1--;
            }

        }

        if (count2 > count1){
            while(diff2 > 0){
                temp2 = temp2.next;
                diff2--;
            }
        }

        while(temp1 != temp2){
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return temp1;
    }
}
