package javaPratice;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class SecondLargerstElement {
    public static void main(String[] args) {
        int[] nums   = {1,2,5,9,8,7};
        System.out.println(findSecondLargestUsingMaxHeap(nums));
        System.out.println(findSecondLargestOpti(nums));
    }



    private static int findSecondLargestOpti(int[] nums) {
        int max =  nums[0];
        int secondMax = Integer.MIN_VALUE;

        for(int i=1; i<nums.length; i++){
            if(nums[i] > max){
                secondMax = max;
                max = nums[i];
            } else if(nums[i] > secondMax){
                secondMax = nums[i];
            }
        }

        return secondMax;
    }

    private static int findSecondLargest(int[] nums) {
        int max = 0;
        int secondMax = 0;

        for(int i=0; i<nums.length; i++){
            max = Math.max(max, nums[i]);
        }

        for(int i=0; i<nums.length; i++){
            if(nums[i] != max){
                secondMax = Math.max(secondMax, nums[i]);
            }
        }

        return secondMax;
    }

    private static int findSecondLargestUsingMaxHeap(int[] nums){
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<nums.length; i++){
            maxHeap.add(nums[i]);
        }
        maxHeap.remove();
        return maxHeap.remove();
    }
}
