package dataStructuresPractice.general.mock.interviews;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,7,8,9};
        findMissingNumber(arr, 9);
        findMissingNumberUsingXOR(arr, 9);
    }

    private static void findMissingNumber(int[] arr, int n) {

        int totalSum = 0;
        totalSum = (n* (n+1))/2;

        for (int i=0; i<arr.length; i++){
            totalSum = totalSum - arr[i];
        }
        System.out.println("Missing number : " + totalSum);
    }

    static void findMissingNumberUsingXOR(int[] arr, int n){
        int length = arr.length;
        int xorValue = 0;

        for (int i=1; i<=n; i++){
            xorValue = xorValue ^ i;
        }
        for (int i=0; i<length; i++){
            xorValue = xorValue ^ arr[i];
        }
        System.out.println("Missing number : " + xorValue);
    }
}
