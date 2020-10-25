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

        Queue<Double> smaller = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Double> larger = new PriorityQueue<>();

        double median = medianArray[0];
        System.out.print("Median = " + median + " ");
        smaller.add(median);

        for (int i = 1; i < medianArray.length; i++) {
            double x = medianArray[i];
            if (smaller.size() > larger.size()) {
                if (x < median) {
                    larger.add(smaller.poll());
                    smaller.add(x);
                } else {
                    larger.add(x);
                }
                median = (smaller.peek() + larger.peek()) / 2;
                System.out.print(median + " ");
            } else if (smaller.size() == larger.size()) {
                if (x < median) {
                    smaller.add(x);
                    median = smaller.peek();
                    System.out.print(median + " ");
                } else {
                    larger.add(x);
                    median = larger.peek();
                    System.out.print(median + " ");
                }
            } else {
                if (x > median) {
                    smaller.add(larger.poll());
                    larger.add(x);
                } else {
                    smaller.add(x);
                }
                median = (smaller.peek() + larger.peek()) / 2;
                System.out.print(median + " ");
            }
        }
    }
}
