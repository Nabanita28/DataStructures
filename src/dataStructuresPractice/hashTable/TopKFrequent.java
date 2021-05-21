package dataStructuresPractice.hashTable;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TopKFrequent {

    public static void main(String[] args) {
        int[] result = topKFrequent(new int[]{4,1,-1,2,-1,2,3}, 2);
        for(int i=0; i<result.length; i++){
            System.out.print(result[i] + " ");
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int item = nums[i];
            if(map.containsKey(item)){
                map.put(item, map.get(item) + 1);
            }else{
                map.put(item, 1);
            }
        }

        Map<Integer, Integer>  sortedMap = map.entrySet().stream().sorted((i1, i2) -> i2.getValue().compareTo(i1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));

        int[] result = new int[k];

        for(Map.Entry entry : sortedMap.entrySet()){
            if(k==0) break;
            result[k-1] = (int)entry.getKey();
            k--;
        }
        return result;
    }
}
