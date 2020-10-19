package arrays.mockInterviews;

import java.util.Arrays;

public class ProductArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        printProductArray(arr);
    }

    static void printProductArray(int inputArr[]) {
        int len = inputArr.length;
        int[] product = new int[len];

        for (int i=0; i<len; i++){
            product[i] = 1;
        }

        int temp = 1;
        for (int i=0; i<len; i++){
            product[i] = temp;
            temp = temp * inputArr[i];
        }

        temp = 1;
        for (int i=len-1; i>=0; i--){
            product[i] = product[i] * temp;
            temp = temp * inputArr[i];
        }

        Arrays.stream(product).forEach(element-> System.out.print(element + " "));
    }


}
