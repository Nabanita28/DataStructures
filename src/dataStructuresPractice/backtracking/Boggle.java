package dataStructuresPractice.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Boggle {
    public static void main(String[] args) {
        char boggle[][] = { { 'G', 'I', 'Z' },
                            { 'U', 'E', 'K' },
                            { 'Q', 'S', 'E' } };
        String dictionary[] = { "GEEKS", "FOR", "QUIZ", "GUQ", "EE" };
        String[] words = wordBoggle(boggle, dictionary);

        Arrays.stream(words).forEach(s-> System.out.print(s + " "));
    }
    public static String[] wordBoggle(char board[][], String[] dictionary)
    {
        int m = board.length;
        int n = board[0].length;

        List<String> result = new ArrayList<>();

        boolean[][] visited = new boolean[m][n];


        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                findWords(i, j, "", visited, board, dictionary, result);
            }
        }

        String[] resultArray = result.stream().distinct().toArray(String[]::new);

        return resultArray;
    }

    static void findWords(int row, int col, String current, boolean[][] visited , char board[][], String[] dictionary, List<String> result ){

        visited[row][col] = true;

        current = current + board[row][col];

        if(isWord(current, dictionary)){
            System.out.println(current);
            result.add(current);
        }

        //dfs
        for(int k=row-1; k<=row+1 && k<board.length; k++){
            for(int l=col-1; l<=col+1 && l<board[0].length; l++ ){
                if(k >= 0 && l >= 0 && !visited[k][l]){
                    findWords(k, l, current, visited, board, dictionary, result);
                }

            }
        }

        visited[row][col] = false;

    }


    static  boolean isWord(String str, String[] dictionary){
        for(int i=0; i<dictionary.length; i++){
            if(str.equals(dictionary[i])){
                return true;
            }
        }
        return false;
    }
}
