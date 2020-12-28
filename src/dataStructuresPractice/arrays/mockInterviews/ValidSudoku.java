package dataStructuresPractice.arrays.mockInterviews;

import java.util.Arrays;

public class ValidSudoku {
    public static void main(String[] args) {

        char[][] board = { { 7, 9, 2, 1, 5, 4, 3, 8, 6 },
                { 6, 4, 3, 8, 2, 7, 1, 5, 9 },
                { 8, 5, 1, 3, 9, 6, 7, 2, 4 },
                { 2, 6, 5, 9, 7, 3, 8, 4, 1 },
                { 4, 8, 9, 5, 6, 1, 2, 7, 3 },
                { 3, 1, 7, 4, 8, 2, 9, 6, 5 },
                { 1, 3, 6, 7, 4, 8, 5, 9, 2 },
                { 9, 7, 4, 2, 1, 5, 6, 3, 8 },
                { 5, 2, 8, 6, 3, 9, 4, 1, 7 } };
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {

        int sudokuLength = 9;
        boolean[] unique = new boolean[sudokuLength+1];

        if(!isInRange(board)){
            return false;
        }

        //rows
        for(int i=0; i<9; i++){
            Arrays.fill(unique, false);
            for(int j=0; j<9; j++){
                if(board[i][j] != '.'){
                    continue;
                }
                int item = board[i][j] - '0' - 1;

                if(unique[item]){
                    return false;
                }

                unique[item] = true;

            }
        }
        //columns
        for(int i=0; i<sudokuLength; i++){
            Arrays.fill(unique, false);
            for(int j=0; j<sudokuLength; j++){
                if(board[i][j] != '.'){
                    continue;
                }
                int item = board[i][j] - '0' - 1;

                if(unique[item]){
                    return false;
                }

                unique[item] = true;
            }
        }

        //for 3x3 matrix
        for(int i=0; i<7; i++){
            for(int j=0; j<7; j++){

                Arrays.fill(unique, false);

                for(int k=0; k<3; k++){
                    for(int l=0; l<3; l++){

                        int row = i + k;
                        int col = j + l;
                        if(board[i][j] != '.'){
                            continue;
                        }
                        int item = board[row][col] - '0' - 1;

                        if(unique[item]){
                            return false;
                        }

                        unique[item] = true;

                    }
                }
            }
        }

        return true;
        //end
    }


    static boolean isInRange(char[][] board){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){

                if(board[i][j] <= 0 && board[i][j] > 9){
                    return false;
                }
            }
        }

        return true;
    }
}
