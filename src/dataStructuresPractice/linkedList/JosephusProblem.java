package dataStructuresPractice.linkedList;

public class JosephusProblem {
    public static void main(String[] args) {
        System.out.println(solveJosephusProblem(100, 2));
    }

    static int solveJosephusProblem(int numberOfPeople, int k){

        //create a circular linked list
        Node head = new Node(1);
        Node prev = head;
        for(int i=2; i<=numberOfPeople; i++){
            prev.next = new Node(i);
            prev = prev.next;
        }
        prev.next = head;

        Node first = head;
        Node second = head;

        while(first.next != first){

            int counter = 1;
            while (counter != k){
                second = first;
                first = first.next;
                counter++;
            }
            second.next = first.next;
            first = second.next;

        }
        return first.data;
    }
}
