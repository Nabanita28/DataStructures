package algoProblems.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class RiverSizes {
    public static void main(String[] args) {
        int[][] rivers = new int[][]{
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0},
        };
        System.out.println(riverSizes(rivers));
    }

    public static List<Integer> riverSizes(int[][] matrix) {

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        List<Integer> riverSizes = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    int sizeOfRiver = bfs(i, j, visited, matrix);
                    riverSizes.add(sizeOfRiver);
                }
            }
        }
        return riverSizes;
    }

    private static Integer bfs(int row, int col, boolean[][] visited, int[][] matrix) {

        Queue<River> queue = new LinkedList<>();
        River river = new River(row, col);
        queue.add(river);
        visited[river.x][river  .y] = true;
        int count = 0;
        while (!queue.isEmpty()) {
            River curr = queue.remove();
            count++;

            List<River> adjacentVertices = getNeighbours(curr.x, curr.y, matrix);

            for (int i = 0; i < adjacentVertices.size(); i++) {
                River tempRiver = adjacentVertices.get(i);

                if (!visited[tempRiver.x][tempRiver.y]) {
                    queue.add(tempRiver);
                    visited[tempRiver.x][tempRiver.y] = true;
                }
            }
        }
        return count;
    }

    static List<River> getNeighbours(int x, int y, int[][] matrix) {

        List<River> neighbours = new ArrayList<>();
        neighbours.add(new River(x - 1, y));
        neighbours.add(new River(x + 1, y));
        neighbours.add(new River(x, y - 1));
        neighbours.add(new River(x, y + 1));

        return validNeighbours(neighbours, matrix);
    }

    static List<River> validNeighbours(List<River> neighbours, int[][] matrix) {

        return neighbours.stream().filter(river -> river.x >= 0 && river.x < matrix.length && river.y >= 0
                && river.y < matrix[0].length && matrix[river.x][river.y] == 1).collect(Collectors.toList());
    }

    static class River {
        int x;
        int y;

        public River(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
