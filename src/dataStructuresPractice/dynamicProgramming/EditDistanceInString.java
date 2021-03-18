package dataStructuresPractice.dynamicProgramming;

import java.util.Arrays;
import java.util.Collections;

public class EditDistanceInString {
    public static void main(String[] args) {
        String str1 = "intrinsic";
        String str2 = "intrusive";

        int dist = minDistance(str1, str2);
        System.out.println("Minimum number of edits required:- " + dist);

    }

    static int minDistance(String str1, String str2){

        int[][] memo = new int[str1.length() + 1][str2.length() + 1];

        for (int i=0; i<=str1.length(); i++){
            for (int j=0; j<=str2.length(); j++){

                if (i == 0){
                    memo[i][j] = j;
                } else if (j == 0){
                    memo[i][j] = i;
                }else if (str1.charAt(i-1) == str2.charAt(j-1)){
                    memo[i][j] = memo[i-1][j-1];
                }else{
                    memo[i][j] = min( 1 + memo[i-1][j], //insert
                                      1 + memo[i][j-1], //delete
                                      2 + memo[i-1][j-1] //substitute
                    );
                }

            }
        }
            return memo[str1.length()][str2.length()];
    }

    static int min(int insert, int delete, int substitute){
        Integer[] values = {insert, delete, substitute};
        return Collections.min(Arrays.asList(values));
    }
}
