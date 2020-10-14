package general.mock.interviews;

import java.util.Arrays;

public class NextGreaterNumber {
    public static void main(String[] args) {
        int number = 534976;
        findNextGreaterNumber(number);
    }

    private static void findNextGreaterNumber(int number) {

        char[] arr = String.valueOf(number).toCharArray();
        int i = arr.length-1;
        int length = arr.length;
        while(i > 0 && arr[i-1] > arr[i]){
            i--;
        }
        if (i == 0)
            System.out.println("Not possible");
        else{
            char temp = arr[i-1];
            arr[i-1] = arr[length-1];
            arr[length-1] = temp;

            //here we pass fromIndex as i and toIndex as length(noy length-1), because, in Arrays.sort - the index of the last element is already taken as high-1
            Arrays.sort(arr, i, length);

            System.out.println("Next Greater Number is : " + Integer.parseInt(new String(arr)));
        }
    }
}
