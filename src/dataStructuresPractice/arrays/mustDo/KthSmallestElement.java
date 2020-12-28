package dataStructuresPractice.arrays.mustDo;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestElement {
    public static void main(String[] args) {
        int[] arr = new int[]{12, 3, 5, 7, 19};
        System.out.println("k'th smallest element is " + kthSmallestElementUsingMaxHeap(arr, 2));
        int[] arr2 = new int[]{12, 3, 5, 7, 19};
        kthLargestElement(arr2, 3);
    }

    //time complexity - O(n+klogn) space complexity is O(n)
    static int kthSmallestElement(int[] arr, int k) {
        Queue<Integer> queue = new PriorityQueue<>();

        for (int i : arr) {
            queue.add(i);
        }
        int smallestElement = 0;
        for (int i = 0; i < k; i++) {
            smallestElement = queue.remove();
        }
        return smallestElement;
    }


    // O(k + (n-k)log(k))
    // O(n) ignoring the constants and space complexity is O(1)
    static int kthSmallestElementUsingMaxHeap(int[] arr, int k) {

        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            queue.add(arr[i]);
        }
        for (int j = k; j < arr.length; j++) {
            if (arr[k] < queue.peek()) {
                queue.remove();
                queue.add(arr[k]);
            }
        }
        return queue.poll();
    }

    static void kthLargestElement(int[] arr, int k) {
        {

            Queue<Integer> priorityQueue = new PriorityQueue<>();

            for (int i = 0; i < k; i++) {
                priorityQueue.add(arr[i]);
            }
            for (int j = k; j < arr.length; j++) {
                if (arr[j] > priorityQueue.peek()) {
                    priorityQueue.remove();
                    priorityQueue.add(arr[j]);
                }
            }
            System.out.println("K Largest elements are : ");
            priorityQueue.stream().forEach(s -> System.out.print(s + " "));

        }

    }
}
