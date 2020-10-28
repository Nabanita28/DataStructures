package arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = rotateArray(new int[]{1,2,3,4,5}, 3);
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    private static int[] rotateArray(int[] nums, int k) {
        int n = nums.length;
        reverse(nums,0, n-1);
        reverse(nums,0, k-1);
        reverse(nums, k,n-1);
        return nums;
    }

    private static void reverse(int[] nums, int start, int end) {
        int temp = 0;
        for (int i=start; i<end; i++){
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

   /* public static int[] rotateArray(int[] arr, int k) {
        int j = 0;
        int i = arr.length-1;
            while(k!=0){
            j = i-1;
            int l = arr[i];
            while(j!=-1){
                arr[j+1] = arr[j];
                j--;
            }
            arr[0] = l;
            k--;
        }
        return arr;
    }*/
}
