package dataStructuresPractice.arrays.mockInterviews;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        int[][] coordinates = new int[][]{{3, 3}, {5, -1}, {-2, 4}};
        findKClosestPointsToOrigin(coordinates, 3);
    }

    static public int[][] findKClosestPointsToOrigin(int[][] points, int k) {
        Queue<Pair> pqueue = new PriorityQueue<>(new PairComparator());

        for (int i = 0; i < points.length; i++) {
            pqueue.add(new Pair(points[i][0], points[i][1]));
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            Pair currentPair = pqueue.poll();
            result[i][0] = currentPair.first;
            result[i][1] = currentPair.second;
        }

        return result;
    }

    static class PairComparator implements Comparator<Pair> {


        @Override
        public int compare(Pair firstPair, Pair secondPair) {
            int first_pair = firstPair.first * firstPair.first + firstPair.second * firstPair.second;
            int second_pair = secondPair.first * secondPair.first + secondPair.second * secondPair.second;

            return (first_pair - second_pair);
        }
    }

    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}