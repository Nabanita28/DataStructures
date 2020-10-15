package arrays;

public class MatrixRotation {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 3, 4},
                                  {5, 6, 7, 8},
                                  {9, 10, 11, 12},
                                  {13, 14, 15, 16}};
        rotateMatrix(arr);
    }

    //first we swap diagonally
    private static void rotateMatrix(int[][] array) {
        int n = array.length;
        //1st rotation
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (r > c) {
                    int temp = array[r][c];
                    array[r][c] = array[c][r];
                    array[c][r] = temp;
                }
            }
        }

        //printMatrix(array);
        System.out.println("First rotation");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        //2nd rotation - then we swap parallel rows - left and right rows - matrix[row][col] with matrix[row][n-1-c] where n is the total no. of columns
        for (int i = 0; i < n; i++) {
            for (int c = 0; c < n/2; c++) {
                int temp = array[i][c];
                array[i][c] = array[i][n - 1 - c];
                array[i][n - 1 - c] = temp;
            }
        }
        //printMatrix(array);
        System.out.println();
        System.out.println("2nd rotation");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
