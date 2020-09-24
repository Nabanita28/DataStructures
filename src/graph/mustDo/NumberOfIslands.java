package graph.mustDo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class NumberOfIslands {

    public static void main(String[] args) {
        System.out.println("Number of Islands : " + findNumberOfIslands(earth));
    }

    static int[][] earth = new int[][]
                          {{1,0,0,1},
                           {0,1,0,0},
                           {1,1,0,1},
                           {0,0,0,1},
                           {1,1,1,1},
                           {1,1,0,1}};

    static class Island {
        int x;
        int y;

        public Island(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int findNumberOfIslands(int[][] earth) {

        int count = 0;
        int row_length = earth.length;
        int col_length = earth[0].length;

        boolean[][] visited = new boolean[row_length][col_length];

        for (int i = 0; i < row_length; i++) {
            for (int j = 0; j < col_length; j++) {
                if (earth[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private static void bfs(int row, int col, boolean[][] visited) {

        Queue<Island> queue = new LinkedList<>();
        Island island = new Island(row, col);
        queue.add(island);
        visited[island.x][island.y] = true;

        while (!queue.isEmpty()) {
            Island current = queue.remove();

            List<Island> neighbours = getNeighbour(current.x, current.y);

            for (int i = 0; i < neighbours.size(); i++) {
                Island next = neighbours.get(i);

                if (!visited[next.x][next.y]) {
                    queue.add(next);
                    visited[next.x][next.y] = true;
                }
            }
        }
    }



    public static List<Island> getNeighbour(int row, int col) {

        List<Island> islands = new ArrayList<>();
        islands.add(new Island(row, col - 1));
        islands.add(new Island(row, col + 1));
        islands.add(new Island(row - 1, col));
        islands.add(new Island(row + 1, col));
        islands.add(new Island(row + 1, col+1));
        islands.add(new Island(row - 1, col-1));
        islands.add(new Island(row + 1, col-1));
        islands.add(new Island(row - 1, col+1));

        return getValidIslands(islands);
    }

    private static List<Island> getValidIslands(List<Island> islands) {
        int row_len = earth.length;
        int col_len = earth[0].length;
        return islands.stream().filter(island -> island.x >= 0 && island.y >= 0 && island.x < row_len && island.y < col_len && earth[island.x][island.y] == 1).collect(Collectors.toList());
    }
}
