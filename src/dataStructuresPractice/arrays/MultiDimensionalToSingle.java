package dataStructuresPractice.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MultiDimensionalToSingle {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}
        };
        convertMultiDimensionalToSingleDimensionalSortedArray(arr);
    }

    private static void convertMultiDimensionalToSingleDimensionalSortedArray(int[][] arr) {
        Queue<Integer> queue = new PriorityQueue<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                queue.add(arr[i][j]);
            }
        }
        while (!queue.isEmpty()) {
            list.add(queue.remove());
        }
        System.out.println(list);
    }

}
