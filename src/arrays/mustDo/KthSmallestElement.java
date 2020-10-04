package arrays.mustDo;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestElement {
    public static void main(String[] args) {
        int[] arr = new int[]{12, 3, 5, 7, 19 };
        System.out.println("k'th smallest element is " + kthSmallestElement(arr, 3));
    }

    static int kthSmallestElement(int[] arr, int k){
        Queue<Integer> queue = new PriorityQueue<>();

        for (int i : arr){
            queue.add(i);
        }
        int smallestElement = 0;
        for (int i = 0; i<k; i++){
            smallestElement = queue.remove();
        }
        return smallestElement;
    }
}
