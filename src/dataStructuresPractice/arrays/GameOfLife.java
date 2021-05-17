package dataStructuresPractice.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameOfLife {
    public static void main(String[] args) {
        int[][] board = new int[][]{
                {1,0,0,1},
                {0,1,0,0},
                {1,1,0,1},
                {0,0,0,1},
                {1,1,1,1},
                {1,1,0,1}
        };
        gameOfLife(board);
    }

        public static void gameOfLife(int[][] board) {
            int m = board.length;
            int n = board[0].length;

            int[][] nextState = new int[m][n];
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    computeNextState(i, j, board, nextState);
                }
            }
            for(int i=0; i<m; i++){

                for(int j=0; j<n; j++){

                    board[i][j] = nextState[i][j];
                }
            }


        }

       static void computeNextState(int row, int col, int[][] board, int[][] nextState){

            int liveCells = getNeighbours(row, col, board);

            if(liveCells < 2){
                nextState[row][col] = 0;
            }
            else if(liveCells > 3){
                nextState[row][col] = 0;
            }
            else if(liveCells == 3){
                nextState[row][col] = 1;
            } else{
                nextState[row][col] = board[row][col];
            }

        }

        static class Cell{
            int x;
            int y;

            Cell(int x, int y){
                this.x = x;
                this.y = y;
            }
        }


       static int getNeighbours(int row, int col, int[][] board){

            Cell[] cells = {new Cell(row-1, col),
                    new Cell(row+1, col),
                    new Cell(row, col-1),
                    new Cell(row, col+1),
                    new Cell(row-1, col-1),
                    new Cell(row+1, col+1),
                    new Cell(row+1, col-1),
                    new Cell(row-1, col+1)};

            List<Cell> validCells = Arrays.stream(cells).filter(cell -> cell.x >= 0 && cell.x < board.length
                    && cell.y >= 0 && cell.y < board[0].length)
                    .collect(Collectors.toList());

            //by Rajeev
            return getLiveNeighbours(validCells, board);

        }

      static  int getLiveNeighbours(List<Cell> neighbours, int[][] board){
            long count = neighbours.stream().filter(cell -> board[cell.x][cell.y] == 1).count();
            return Math.toIntExact(count);
        }


}
