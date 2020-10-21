package arrays.mockInterviews;

import graph.AmazonGoStores;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        int[][] coordinates = new int[][]{{1, 0}
                                        , {2, 1}
                                        , {3, 6}
                                        , {-5, 2}
                                        , {1, -4}};
        findKClosestPointsToOrigin(coordinates, 3);
    }

    private static void findKClosestPointsToOrigin(int[][] coordinates, int k) {
        int len = coordinates.length;
        PriorityQueue<Points> queue = new PriorityQueue<>(len, new Comparator<Points>() {
            @Override
            public int compare(Points first, Points second) {
                int x1 = first.x * first.x;
                int y1 = first.y * first.y;
                int x2 = second.x * second.x;
                int y2 = second.y * second.y;

                return (x1 + y1) - (x2 + y2);
            }
        });

        for (int i = 0; i < len; i++) {
                queue.add(new Points(coordinates[i][0], coordinates[i][1]));
            }

        for(int j=0; j<k; j++){
            Points point = queue.poll();
            System.out.print("(x : "  + point.x + ", ");
            System.out.println("y : " + point.y + ")");
            System.out.println();
        }

    }

       static class Points {
            int x;
            int y;

            public Points(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
    }
