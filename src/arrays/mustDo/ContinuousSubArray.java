package arrays.mustDo;

public class ContinuousSubArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,7,5};
        findContinuousSubArray(arr, 5);
    }

    private static void findContinuousSubArray(int[] arr, int sum) {

        int res = arr[0];
        int i = 0;
        int j = i + 1;

        while(i<5){
            res += arr[j];

            if (res < sum)
                j++;

            if (res > sum){
                res = res - arr[i];
                i++;
            }

            if(res == sum){
                System.out.println("Start index = " + i + " End index = " + j);
                break;
            }

        }

    }
}
