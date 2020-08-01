package arrays;
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int newLength = removeDuplicates(nums);
        for(int i=0; i<newLength; i++){
            System.out.println(nums[i]);
        }
    }

    private static int removeDuplicates(int[] nums) {
    int j = 0;
    for(int i = 0; i < nums.length; i++){
        if(i<(nums.length -1) && nums[i] == nums[i+1]){
            continue;
        }
        nums[j++] = nums[i];
    }
    return j;
    }


    /*private static int[] removeDuplicates(int[] nums) {
        for(int i = 0; i<nums.length ; i++){
            if(nums[i] == nums[nums.length - 1]) return nums;
            if(nums[i] == nums[i+1] && i< (nums.length-1)){
                nums = ArrayUtils.remove(nums, nums[i]);
            }
        }

        return nums;
    }*/


}
