package dataStructuresPractice.hashTable;

import java.util.*;

public class CountTripletsGP {
    public static void main(String[] args) {
        List<Long> items = new ArrayList<>(Arrays.asList(1l,2l,2l,4l));
        System.out.println(countTriplets(items, 2));
    }
    static long countTriplets(List<Long> arr, long r) {

        long len = arr.size();
        Map<Long, Long> leftMap = new HashMap<>();
        Map<Long, Long> rightMap = new HashMap<>();

        for(long item : arr){
            rightMap.put(item, rightMap.getOrDefault(item, 0l)+1);
        }
        long count = 0;
        for(int i=0; i<len; i++){
            long c2 = 0; long c1 = 0;
            long midTerm = arr.get(i);
            rightMap.put(arr.get(i), rightMap.getOrDefault(midTerm, 0l) - 1);

            if(leftMap.containsKey(midTerm/r) && (midTerm % r == 0)){
                c1 = leftMap.get(midTerm/r);
            }
            if(rightMap.containsKey(midTerm*r)){
                c2 = rightMap.get(midTerm*r);
            }

            count = count + (c1*c2);
            leftMap.put(midTerm, leftMap.getOrDefault(midTerm, 0l) + 1);
        }
        return count;
    }
}
