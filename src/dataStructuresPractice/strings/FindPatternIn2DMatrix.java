package dataStructuresPractice.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FindPatternIn2DMatrix {
    //Given a 2D grid of characters and a word, find all occurrences of the given word in the grid. A word can be matched in all 8 directions at any point. Word is said to be found in a direction if all characters match in this direction (not in zig-zag form).
    //The 8 directions are, Horizontally Left, Horizontally Right, Vertically Up, Vertically Down and 4 Diagonal directions.
//Time complexity: O(R*C*8*len(str)).
    public static void main(String[] args) {
        char[][] matrix = {{'M', 'C', 'P', 'R', 'C'},
                           {'X', 'S', 'O', 'P', 'C'},
                           {'V', 'O', 'V', 'N', 'I'},
                           {'W', 'G', 'F', 'M', 'N'},
                           {'Q', 'A', 'T', 'I', 'T'}};
        System.out.println(isPatternPresent(matrix, "NAB"));
    }

    static boolean isPatternPresent(char[][] matrix, String pattern) {
        int M = matrix.length;
        int N = matrix[0].length;
        int patternIndex = 0;
        boolean[][] isVisited = new boolean[M][N];
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if (matrix[i][j] == pattern.charAt(patternIndex)){
                    boolean result = dfs(i, j, matrix, pattern, isVisited, patternIndex);
                    if(result){
                        System.out.println("Pattern found at : [" + i + ", " + j +"]");
                        return true;
                    }
                }
            }
        }
        System.out.println("Pattern not found");
        return false;
    }

    static boolean dfs(int row, int col, char[][] matrix, String pattern, boolean[][] isVisited, int patternIndex){
        //base condition
        if(patternIndex == pattern.length()-1){
            return true;
        }

        isVisited[row][col] = true;

        List<Point> neighbours = getNeighbours(row, col, matrix);

        for(Point point : neighbours){

                if(pattern.charAt(patternIndex + 1) == matrix[point.x][point.y] && !isVisited[point.x][point.y]){
                    isVisited[point.x][point.y] = true;
                    boolean success = dfs(point.x, point.y, matrix, pattern, isVisited, patternIndex+1);
                    if(success){
                       return true;
                    }else{
                        //unmarking neighbour which didn't led to further pattern matching
                        isVisited[point.x][point.y] = false;
                    }
                }else{
                    continue;
                }
        }
        return false;

    }

    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static List<Point> getNeighbours(int row, int col, char[][] matrix){
        List<Point> neighbours = new ArrayList<>();
        neighbours.add(new Point(row-1,col-1));
        neighbours.add(new Point(row-1,col));
        neighbours.add(new Point(row-1,col+1));
        neighbours.add(new Point(row,col-1));
        neighbours.add(new Point(row,col+1));
        neighbours.add(new Point(row+1, col-1));
        neighbours.add(new Point(row+1,col));
        neighbours.add(new Point(row+1,col+1));
       return validNeighbours(neighbours, matrix);
    }

    static List<Point> validNeighbours(List<Point> neighbours, char[][] matrix){
        return neighbours.stream().filter(point -> point.x >= 0 && point.x <matrix.length && point.y >= 0 && point.y < matrix[0].length).collect(Collectors.toList());
    }
}
