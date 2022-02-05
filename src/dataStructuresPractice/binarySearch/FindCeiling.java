package dataStructuresPractice.binarySearch;

public class FindCeiling {
    public static void main(String[] args) {
      //  System.out.println(searchCeilingOfANumber(new int[] { 4, 6, 10 }, 6));
        System.out.println(searchCeilingOfANumber(new int[] { 1, 3, 8, 10, 15 }, 12));
      // System.out.println(searchCeilingOfANumber(new int[] { 4, 6, 10 }, 17));
     //   System.out.println(searchCeilingOfANumber(new int[] { 4, 6, 10 }, -1));
    }
    public static int searchCeilingOfANumber(int[] nums, int target) {
        int start = 0; int end = nums.length-1;

        if(target > nums[nums.length-1]){
            return -1;
        }

        while(start <= end){
            int mid = (start+end)/2;

            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] > target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return start;
    }
}
