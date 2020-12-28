package dataStructuresPractice.deque;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumElementInKSubArray {
    public static void main(String[] args) {
        int[] arr = new int[]{12, 1, 78, 90, 57, 89, 56};
        int k = 3;
        printMaximumElementInKSubArray(arr, k);
    }

    private static void printMaximumElementInKSubArray(int[] arr, int k) {

        int len = arr.length;

        Deque<Integer> deque = new LinkedList<>();
        int i;
        //Add for k elements
        for (i = 0; i < k; i++) {
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }

        //process rest of the elements
        for (; i < len; i++) {

            System.out.print(arr[deque.peek()] + " ");

            //remove elements which are not part of the current window
            while (!deque.isEmpty() && i - k >= deque.peek()) {
                deque.removeFirst();
            }

            //Remove all elements smaller than the currently being added element (remove useless elements)
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        System.out.print(arr[deque.peek()]);
    }
}
