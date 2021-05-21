package dataStructuresPractice.arrays;

import java.time.LocalDate;
import java.util.ArrayList;

public class DownwardDiagonal {

    public static void main(String[] args) {
        int[][] matrix = {  {62, 92, 96, 43},
                            {28, 37, 92, 5},
                            {3, 54, 93, 83},
                            {22, 17, 19, 96}};
        //25 79 63 59 65 46 6 82 28
        ArrayList<Integer> result = downwardDiagonalCorrectApproach(4, matrix);
        result.forEach(item -> System.out.print(item + " "));
    }

    static ArrayList<Integer> downwardDigonal(int n, int A[][])
    {
        ArrayList<Integer> result = new ArrayList<>();
        String s = "wednesday";
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){

                if(i==j){
                    if(!result.contains(A[i][j])){
                        result.add(A[i][j]);
                    }
                    continue;
                } if(i<j && (j-i) == 1){
                    if(!result.contains(A[i][j])){
                        result.add(A[i][j]);
                    }
                    if(!result.contains(A[j][i])){
                        result.add(A[j][i]);
                    }
                    continue;
                } if(i<j && (j-i) > 1){
                    int temp_i = i;
                    int temp_j = j;
                    if(!result.contains(A[i][j])){
                        result.add(A[i][j]);
                    }
                    int diff = temp_j - temp_i;
                    while(diff != 0){
                        if(!result.contains(A[temp_i+1][temp_j-1])){
                            result.add(A[temp_i+1][temp_j-1]);
                        }
                        diff--; temp_i++; temp_j--;
                    }
                    continue;
                }
            }
        }
        return result;
    }

    static ArrayList<Integer> downwardDiagonalCorrectApproach(int n, int A[][])
    {
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0; i<n; i++){

            int row = 0; int col = i;

            while(col >= 0){
                result.add(A[row][col]);
                row++;
                col--;
            }

        }

        //second half diagonal

        for(int i=1; i<n; i++){
            int col = n-1; int row = i;

            while(col >= 0 && row<n){
                result.add(A[row][col]);
                row++;
                col--;
            }
        }

        return result;
    }
}
