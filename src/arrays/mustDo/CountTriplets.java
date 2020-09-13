package arrays.mustDo;

import java.util.Arrays;

public class CountTriplets {
    public static void main(String[] args) {
        int[] arr = new int[]{1,5,3,2};
        findTriplets(arr);
    }

    private static void findTriplets(int[] arr) {

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        int i = arr.length -1;
        int j = i-1;
        int k = 0;

        while(i>0 && j>0){

            if(arr[i] == arr[j] + arr[k]){
                System.out.println(arr[j] + " + " + arr[k] + " = " + arr[i]);
                i--;
                j=i-1;
                k=0;
            }

            if (arr[i] < arr[j] + arr[k])
                j--;

            if (arr[i] > arr[j] + arr[k])
                k++;
        }
    }
}
