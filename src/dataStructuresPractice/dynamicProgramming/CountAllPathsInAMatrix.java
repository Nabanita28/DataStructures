package dataStructuresPractice.dynamicProgramming;

public class CountAllPathsInAMatrix {
    public static void main(String[] args) {
        countAllPathsInAMatrix(3,3);
    }

    private static void countAllPathsInAMatrix(int m, int n) {

        int[][] count = new int[3][3];

        for (int i=0; i<m; i++)
            count[i][0] = 1;

        for(int j=0; j<n; j++)
            count[0][j] = 1;

        for (int i=1; i<m; i++){
            for (int j=1; j<n; j++){
                count[i][j] += count[i-1][j] + count[i][j-1];
            }
        }
        System.out.println("Total number of paths from top left to bottom right : " + count[m-1][n-1]);
    }
}
