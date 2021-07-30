package dataStructuresPractice.stack;

public class PeakElement {
    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1,2,3}));
    }

    public static int findPeakElement(int[] nums) {
        int i = 0;
      for( i=1; i<nums.length-1; i++){
          if(nums[i-1] < nums[i] && nums[i] > nums[i+1]){
              return i;
          }
        }



      if(i == nums.length-1){
          if(nums[i] > nums[i-1]){
              return i;
          }
      }
      return 0;
    }
}
