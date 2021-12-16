package javaPratice.sortMap;

import java.util.*;

public class SortAMapByValues {
    public static void main(String[] args) {
        Map<String, Integer> hm = new HashMap<>();
        hm.put("Math", 98);
        hm.put("Data Structure", 85);
        hm.put("Database", 91);
        hm.put("Java", 95);
        hm.put("Operating System", 79);
        hm.put("Networking", 80);
        Map<String, Integer> output = sortByValue(hm);
        output.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));

    }

    private static Map<String, Integer> sortByValue(Map<String, Integer> hashMap) {

        //1. create a list of entrySet
        List<Map.Entry<String, Integer>> entries = new LinkedList<>(hashMap.entrySet());
        //2. sort the list using Collections.sort
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){
             return o1.getValue().compareTo(o2.getValue());
            }
        });

        Map<String, Integer> result = new LinkedHashMap<>();

        for(Map.Entry<String, Integer> entry : entries){
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
