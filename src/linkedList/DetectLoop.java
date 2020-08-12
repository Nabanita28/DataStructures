package linkedList;

public class DetectLoop {

    static Node head;

        public static boolean isLoopDetected(){

            Node slowPointer = head;
            Node fastPointer = head;
            int count = 0;
            while(fastPointer.next !=null && fastPointer.next.next != null){
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next.next;
                if(fastPointer == slowPointer) return true;
                count++;
            }
            return false;
        }

// return the count of loop
    public static int countOfLoopDetected() {

        Node slowPointer = head;
        Node fastPointer = head;
        Node tempNode;
        int count = 1;
        while (fastPointer.next != null && fastPointer.next.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (fastPointer == slowPointer) {
                tempNode = slowPointer;
                slowPointer = slowPointer.next;
                while (slowPointer != tempNode) {
                    count++;
                    slowPointer = slowPointer.next;
                }
                return count;
            }
        }
            return 0;
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
            sixthNode.next = thirdNode;

            System.out.println("Loop detected -> " + isLoopDetected());
            System.out.println("Loop count : " + countOfLoopDetected());
        }
    }

