package dataStructuresPractice.arrays;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static void main(String[] args) {

        int[] nums =  {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }
        public static int majorityElement(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();

            for(int i=0; i< nums.length; i++){
                if(map.containsKey(nums[i])){
                    map.put(nums[i], map.get(nums[i]) + 1);
                } else{
                    map.put(nums[i], 1);
                }
            }

            int value = 0;
            int max = 0;
            for(Map.Entry entry : map.entrySet()){
                if(max < (int)entry.getValue()){
                    max = (int)entry.getValue();
                    value = (int)entry.getKey();
                }
            }

            return value;
        }
    }
