package arrays.mustDo;

public class EquilibriumPosition {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,2,2};
        System.out.println("Equilibrium position is at index : " + findEquilibriumPosition(arr));
    }

    private static int findEquilibriumPosition(int[] arr) {
        int i, j = arr.length-1;
        int sumOfLow = 0;
        int sumOfHigh = 0;
        for (i=0; i<j; i++, j--) {

            sumOfLow += arr[i];
            sumOfHigh += arr[j];

            while (sumOfLow < sumOfHigh && i < j) {
                i++;
                sumOfLow += arr[i];
            }

            while (sumOfHigh < sumOfLow && i < j) {
                j--;
                sumOfHigh += arr[j];
            }
        }
            if (sumOfLow == sumOfHigh )
                return i;

        return -1;
    }
}
