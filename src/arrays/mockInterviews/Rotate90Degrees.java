package arrays.mockInterviews;

public class Rotate90Degrees {
    public static void main(String[] args) {
        //anticlockwise
        int[][] matrix = new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        rotate90Degrees(matrix);
    }

    //first we swap diagonally
    private static void rotate90Degrees(int[][] matrix) {
        int n = matrix.length;
        for(int i=0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                if (i > j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
        //then we swap parallel rows - top and bottom rows - matrix[row][col] with matrix[n-1-i][col] where n is the total no. of rows
        for (int i=0; i<n/2; i++){
            for (int j=0; j<n; j++){
                //swap matrix[i][j] and matrix[n-1-i][j]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-i][j];
                matrix[n-1-i][j] = temp;
            }
        }

        for (int i=0; i<n; i++){
            System.out.println();
            for(int j=0; j<n; j++){
                System.out.print(matrix[i][j] + " ");
            }
        }
    }
}
