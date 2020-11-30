package hashTable;

import java.util.*;
import java.util.stream.Collectors;
import static java.util.Collections.reverseOrder;
import static java.util.Collections.sort;

public class PrintFrequencyReverse {
    public static void main(String[] args) {
        int[] arr = {3,3,3,3,3,5,5,3,6,5,7,6,7,8,1,3,2,2,9};
        sortFrequency(arr);
    }

    private static void sortFrequency(int[] arr) {

        //put values in map
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<arr.length; i++){

            if (map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i]) + 1);
                }
            else{
                map.put(arr[i], 1);
            }
        }


        List<Map.Entry<Integer, Integer>> sorted_map =
                map.entrySet()
                        .stream()
                        .sorted(reverseOrder(Map.Entry.comparingByValue()))
                        .collect(Collectors.toList());

        System.out.println(sorted_map);

        List<Integer> freq = new ArrayList<>();
        map.entrySet().stream().forEach(s-> freq.add(s.getValue()));

        Collections.sort(freq, Collections.reverseOrder());

        System.out.println(freq);
    }
}
