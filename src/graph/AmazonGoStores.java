package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class AmazonGoStores {
    public static class Point {
        public int x;
        public int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }



    static int[][] arr = new int[][]{
            {1,0,0,1},
            {0,1,0,0},
            {1,1,0,1},
            {0,0,0,1},
            {1,1,1,1},
            {1,1,0,1}
    };
    public static void main(String[] args) {

        System.out.println(getNumberOfClusters());
    }

    private static int getNumberOfClusters() {
        int numberOfClusters = 0;

        int row_len = arr.length;
        int col_len = arr[0].length;

        boolean[][] visited = new boolean[row_len][col_len];

        for(int i=0; i<row_len; i++){
            for (int j=0; j<col_len; j++){
                if(arr[i][j] == 1  && !visited[i][j]){
                    bfs(i, j,  visited);
                    numberOfClusters++;
                }
            }
        }
        return numberOfClusters;
    }

    private static void bfs(int row, int col, boolean[][] visited) {

        visited[row][col] = true;

        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(row, col));

        while (!queue.isEmpty()) {
            Point current = queue.remove();

            ArrayList<Point> neighbors = getNeighbours(current.x, current.y);

            for (Point p : neighbors) {
                if (!visited[p.x][p.y]) {
                    queue.add(p);
                    visited[p.x][p.y] = true;
                }
            }

        }
    }

    private static ArrayList<Point> getNeighbours(int row, int col) {

        Point[] neighbours =
                {
                        new Point(row,col-1),
                        new Point(row-1,col),
                        new Point(row,col+1),
                        new Point(row+1,col)
                } ;


        ArrayList<Point> validNeighbors = new ArrayList<>();

        for(Point p : neighbours){
            if(isValid(p.x,p.y)){
                validNeighbors.add(p);
            }
        }

        return validNeighbors;
    }

    private static boolean isValid(int row, int col){
        int row_len = arr.length;
        int col_len = arr[0].length;
        return row >= 0 && row < row_len && col >= 0 && col < col_len && arr[row][col] == 1;
    }


    private static void bfsRecursive(int row, int col, boolean[][] visited){

        visited[row][col] = true;

        ArrayList<Point> validNeighbors = getNeighbours(row, col);

        for (Point p: validNeighbors){
            if(!visited[p.x][p.y])
                bfsRecursive(p.x, p.y, visited);
        }
    }



}
