package dataStructuresPractice.arrays.twoPointers;

public class ShortestSubArrayToBeRemovedToMakeArraySorted {

    public static void main(String[] args) {
        int[] nums = {1,2,3,10,4,2,3,5};
        System.out.println(findLengthOfShortestSubarray(nums));
    }

    public static int findLengthOfShortestSubarray(int[] arr) {
        int left = 0;
        int right = arr.length-1;

        while(left < right && arr[left] <= arr[left+1]){
            left++;
        }
        if(left == right)
            return 0;

        while(right > left && arr[right] >= arr[right-1]){
            right--;
        }
        //[1,2,3,10,4,2,3,5]
        // left = 3, i.e., arr[3] = 10 and right = 5, i.e., arr[5] = 2
        //now we need to remove a subArray with min length
        //if we remove subArray from left(from index 0 to right), then we will be left with subArray [2,3,5] and we will return subArray [1,2,3,10,4] whose length = 5, which is equal to right
        // if we remove subArray from right(arr.length - 1 - left), then we will be left with subArray [1,2,3,10] and we will return [4,2,3,5] whose length = 4
        // hence we take minimum length of the 2 subArrays min(4,5)
        int result = Math.min(arr.length - 1 - left, right);

        //now we want to delete a subArray from the middle, hence we will compare numbers using 2 pointers at index 0 and right, and keep incrementing i if arr[i] <= arr[j].
        // we will maintain min length at every step by min(res, j-1-i), where j=right and i=0;
        // we do (j-1-i) because we want to calculate the length of the subarray excluding j itself

        int i=0;
        int j = right;

        while(i <= left && j < arr.length){
            if(arr[i] <= arr[j]){
                result = Math.min(result, j-1-i);
                i++;
            }else{
                j++;
            }
        }

        return result;
    }
}
