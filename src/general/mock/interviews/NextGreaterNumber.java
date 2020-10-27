package general.mock.interviews;

import java.util.Arrays;

public class NextGreaterNumber {
    public static void main(String[] args) {
        int number = 534976;
        findNextGreaterNumber(number);
    }

    private static void findNextGreaterNumber(int number) {

        char[] arr = String.valueOf(number).toCharArray();
        int i = arr.length - 1;
        int j = arr.length - 2;
        int length = arr.length;
        while (j > 0 && arr[j] > arr[i]) {
            j--;

            if (j == 0) {
                i--;
                j = i - 1;
            }
        }
        if (i == 0) {
            System.out.println("not possible");
        } else {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            //here we pass fromIndex as i and toIndex as length(not length-1), because, in Arrays.sort - the index of the last element is already taken as high-1
            Arrays.sort(arr, j + 1, length);

            System.out.println("Next Greater Number is : " + Integer.parseInt(new String(arr)));
        }
    }
}
