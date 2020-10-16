package general.mock.interviews;

public class FindTwoMissingNumber {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 6};
        find2MissingNumbers(arr, 6);
    }

    private static void find2MissingNumbers(int[] arr, int n) {
        int xorVar = 0;
        int length = arr.length;
        for (int i = 1; i <= n; i++) {
            xorVar = xorVar ^ i;
        }

        for (int i = 0; i < length; i++) {
            xorVar = xorVar ^ arr[i];
        }

        int set_bit_no = xorVar ^ ~(xorVar - 1);
        int x = 0;
        int y = 0;

        for (int i = 0; i < length; i++) {
            if ((set_bit_no & arr[i]) > 0)
                x = x ^ arr[i];
            else
                y = y ^ arr[i];
        }

        for (int i = 1; i <= n; i++) {
            if ((set_bit_no & i) > 0)
                x = x ^ i;
            else
                y = y ^ i;
        }

        System.out.println("Missing two numbers are : " + x + " and " + y);
    }
}
