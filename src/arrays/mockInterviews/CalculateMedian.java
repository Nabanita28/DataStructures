package arrays.mockInterviews;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class CalculateMedian {
    public static void main(String[] args) {
        int[] medianArray = new int[]{5, 15, 10, 20, 3};
        calculateMedian(medianArray);
    }

    private static void calculateMedian(int[] medianArray) {
        // max heap to store the leftMaxHeap half elements
        Queue<Double> leftMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        //  min-heap to store the greater half elements
        Queue<Double> rightMinHeap = new PriorityQueue<>();

        double median = medianArray[0];
        System.out.print("Median = " + median + " ");

        leftMaxHeap.add(median);

        for (int i = 1; i < medianArray.length; i++) {

            double x = medianArray[i];

            if (leftMaxHeap.size() > rightMinHeap.size()) {
                if (x < median) {
                    rightMinHeap.add(leftMaxHeap.poll());
                    leftMaxHeap.add(x);
                } else {
                    rightMinHeap.add(x);
                }
                median = (leftMaxHeap.peek() + rightMinHeap.peek()) / 2;
                System.out.print(median + " ");
            } else if (leftMaxHeap.size() == rightMinHeap.size()) {
                if (x < median) {
                    leftMaxHeap.add(x);
                    median = leftMaxHeap.peek();
                    System.out.print(median + " ");
                } else {
                    rightMinHeap.add(x);
                    median = rightMinHeap.peek();
                    System.out.print(median + " ");
                }
            } else {
                if (x > median) {
                    leftMaxHeap.add(rightMinHeap.poll());
                    rightMinHeap.add(x);
                } else {
                    leftMaxHeap.add(x);
                }
                median = (leftMaxHeap.peek() + rightMinHeap.peek()) / 2;
                System.out.print(median + " ");
            }
        }
    }
}
