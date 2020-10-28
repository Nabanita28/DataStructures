package arrays;

public class HourGlass {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 1, 1, 0, 0, 0,},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}
                };
        System.out.println("Max sum = " + hourglassSum(arr));
        }
    static int hourglassSum(int[][] arr) {

            int sum = 0;   int max_sum = Integer.MIN_VALUE;
            for(int i=1; i<5; i++){

                for(int j=1; j<5; j++){
                    sum = getHourglassSum(i, j, arr);
                    if(sum > max_sum){
                        max_sum = sum;
                    }
                }

            }
            return max_sum;
        }

    static int getHourglassSum(int row, int col, int[][] arr){
        int total = 0;
        total = total + arr[row-1][col-1] +
                arr[row-1][col] +
                arr[row-1][col+1]+
                arr[row][col]+
                arr[row+1][col-1]+
                arr[row+1][col]+
                arr[row+1][col+1];
        return total;
    }
}
