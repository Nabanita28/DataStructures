package arrays.mockInterviews;

public class SearchInSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}};

        search(matrix, 29);
    }

    private static void search(int[][] matrix, int x) {
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == x) {
                System.out.println("Found at index " + i + ", " + j);
                break;
            }
            if (x > matrix[i][j])
                i++;
            else
                j--;
        }
    }
}
