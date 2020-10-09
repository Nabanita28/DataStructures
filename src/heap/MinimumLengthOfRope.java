package heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumLengthOfRope {
    public static void main(String[] args) {
        int[] lengthsOfRope = new int[]{4,2,7,6,9   };
        findMinimumLengthOfRope(lengthsOfRope, lengthsOfRope.length);
    }

    private static void findMinimumLengthOfRope(int[] lengthsOfRope, int length) {

        Queue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i=0; i<length; i++){
            priorityQueue.add(lengthsOfRope[i]);
        }

        int sum = 0;
        int cost = 0;
        while (priorityQueue.size() > 1){
            sum = priorityQueue.remove() + priorityQueue.remove();
            cost = cost + sum;
            priorityQueue.add(sum);
        }

        System.out.println("Minimum length of the rope = " + cost);
    }
}
