package arrays.mustDo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
       int[] nums1 = {4,9,5};
       int[] nums2 = {9, 4, 9, 8, 4};
        int[] result = intersect(nums1, nums2);

        for(int num : result){
            System.out.print(num + " ");
        }
    }

    public static int[] intersect(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> list = new ArrayList<>();


        int n = nums1.length; int m = nums2.length;
        int i=0; int j=0;

        while(i<n && j<m){
            if(nums1[i] > nums2[j]){
                j++;
            } else if(nums1[i] < nums2[j]){
                i++;
            } else{
                list.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] arr = list.stream().mapToInt(k -> k).toArray();
        return arr;
    }
}
