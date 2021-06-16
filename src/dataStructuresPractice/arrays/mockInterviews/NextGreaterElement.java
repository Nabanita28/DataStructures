package dataStructuresPractice.arrays.mockInterviews;

import java.util.Arrays;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] nums = new int[]{5,1,1};
        nextPermutation(nums);
    }

    public static void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len - 1;

        while (i - 1 >= 0 && nums[i - 1] >= nums[i]) {
            i--;
        }

        if (i == 0) {
            Arrays.sort(nums);
            Arrays.stream(nums).forEach(s -> System.out.print(s + " "));
            return;
        }

        int j = 0;
       if(i == len - 1){
           //swap(i, j, nums)
           int temp = nums[i];
           nums[i] = nums[i-1];
           nums[i-1] = temp;
           Arrays.stream(nums).forEach(s -> System.out.print(s + " "));
           return;
       } else{
           j = i;
           i = i - 1;
       }

        int max = Integer.MAX_VALUE;
        Element element = new Element();

        while (j < len && nums[j] > nums[i]) {
            int diff = nums[j] - nums[i];

            if (diff < max) {
                max = diff;
                element.setIndex(j);
                element.setDiff(max);
            }

            j++;
        }

        int ind = element.getIndex();
        //swap(i, j, nums)
        int temp = nums[i];
        nums[i] = nums[ind];
        nums[ind] = temp;

        Arrays.sort(nums, i+1, len);

        Arrays.stream(nums).forEach(s -> System.out.print(s + " "));
    }

    public static class Element {
        int index;
        int diff;

        public int getIndex() {
            return this.index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getDiff() {
            return this.diff;
        }

        public void setDiff(int diff) {
            this.diff = diff;
        }

    }
}
