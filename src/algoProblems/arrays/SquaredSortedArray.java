package algoProblems.arrays;

public class SquaredSortedArray {
    //Given an integer array nums sorted in non-decreasing order,
    // return an array of the squares of each number sorted in non-decreasing order.


    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        nums = squaredArray(nums);
        for(int num : nums){
            System.out.print(num + " ");
        }
    }

    static int[] squaredArray(int[] nums){

        int[] result = new int[nums.length];

       int n = nums.length, left = 0, right = n-1;

       for(int index = n-1; index>=0; index--){
                if (Math.abs(nums[left]) > Math.abs(nums[right])){
                    result[index] = nums[left] * nums[left];
                    left++;

                }else{
                    result[index] = nums[right] * nums[right];
                    right--;
                }
            }
       return result;
        }
    }
