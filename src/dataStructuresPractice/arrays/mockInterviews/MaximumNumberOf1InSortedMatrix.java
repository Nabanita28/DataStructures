package dataStructuresPractice.arrays.mockInterviews;

public class MaximumNumberOf1InSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]
                {
                        {0,1,1,1},
                        {0,0,1,1},
                        {1,1,1,1},
                        {0,0,0,0}
                };
        findMaximumNumberOf1InARowByKidru(matrix);
    }

    private static void findMaximumNumberOf1InARowByKidru(int[][] matrix) {

        int j = matrix[0].length - 1;
        int maxRowIndex = 0;

        for (int i=0; i<matrix.length; i++){
            while(j>=0 && matrix[i][j] == 1){
                j--;
                maxRowIndex = i;
            }
        }

        System.out.println("Maximum number of 1's is present in the given matrix is present at index : " + maxRowIndex);
    }
}
