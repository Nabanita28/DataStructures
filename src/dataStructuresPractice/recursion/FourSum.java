package dataStructuresPractice.recursion;

import java.util.*;

public class FourSum {
    public static void main(String[] args) {
     int[] nums1 = {1,2};
     int[] nums2 = {-2,-1};
     int[] nums3 = {-1,2};
     int[] nums4 = {0,2};
        System.out.println(fourSumCount(nums1, nums2, nums3, nums4));
    }

    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i : nums1){
            for(int j : nums2){
                map.put(i+j, map.getOrDefault(i+j, 0) + 1);
            }
        }

        int count = 0;
        for(int i : nums3){
            for(int j : nums4){
                count = count + map.getOrDefault(-(i+j), 0);
            }
        }
        return count;
    }
}
