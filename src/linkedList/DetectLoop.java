package linkedList;

public class DetectLoop {

    static Node head;

        public static boolean isLoopDetected(){

            Node slowPointer = head;
            Node fastPointer = head;
            while(fastPointer.next !=null  && fastPointer.next.next != null){
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next.next;
                if(fastPointer == slowPointer) return true;
            }
            return false;
        }

        public static void main(String[] args) {

            Node firstNode = new Node(1);
            Node secondNode = new Node(2);
            Node thirdNode = new Node(3);
            Node fourthNode = new Node(4);
            Node fifthNode = new Node(5);
            Node sixthNode = new Node(6);

            head = firstNode;
            firstNode.next = secondNode;
            secondNode.next = thirdNode;
            thirdNode.next = fourthNode;
            fourthNode.next = fifthNode;
            fifthNode.next = sixthNode;
            sixthNode.next = fourthNode;

            //LinkedList.printList(head);
            System.out.println(isLoopDetected());

        }
    }

