package arrays.mustDo;

import java.util.Arrays;

public class CountTriplets {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 32, 1, 7, 10, 50, 19, 21, 2};
        findTriplets(arr);
    }

    private static void findTriplets(int[] arr) {

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        int i = arr.length -1;
        int j = i-1;
        int k = 0;

        while(i>0) {
            while (k < j) {
                if (arr[i] == arr[j] + arr[k]) {
                    System.out.println(arr[j] + " + " + arr[k] + " = " + arr[i]);
                    i--;
                    j = i - 1;
                    k = 0;
                }

                if (arr[i] < arr[j] + arr[k])
                    j--;

                if (arr[i] > arr[j] + arr[k])
                    k++;
            }
            i--;
            j = i - 1;
            k = 0;
        }
    }
}
