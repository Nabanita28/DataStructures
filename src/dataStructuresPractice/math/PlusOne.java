package dataStructuresPractice.math;

public class PlusOne {
    public static void main(String[] args) {
        int[] arr = plusOne(new int[]{9});
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static int[] plusOne(int[] digits) {

        int n = digits.length-1;
        int carry = 1;

        while(carry > 0 && n >= 0){

            int last_digit = digits[n] + 1;
            digits[n] = last_digit % 10;
            carry = last_digit / 10;
            n--;

        }

        if( carry > 0){
            int[] nums = new int[digits.length+1];
            nums[0] = 1;
            return nums;
        }
        return digits;
    }
}
