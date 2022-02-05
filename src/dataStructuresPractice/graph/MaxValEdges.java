package dataStructuresPractice.graph;

import java.util.*;
import java.util.stream.Collectors;

public class MaxValEdges {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{2,2,1,2}, new int[]{1,3,4,4}));
    }

    public static int solution(int N, int[] A, int[] B) {
        // write your code in Java SE 8
        int len = A.length;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<len; i++){
            map.put(A[i], map.getOrDefault(A[i], 0)+1);
            map.put(B[i], map.getOrDefault(B[i], 0)+1);
        }

        HashMap<Integer, Integer> temp = map.entrySet().stream().sorted((i1, i2) -> i2.getValue().compareTo(i1.getValue())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        int ans = 0;
        int val = N;

        for(Map.Entry entry : temp.entrySet()){
            ans += (int)entry.getValue() * val;
            val--;
        }

        return ans;

    }

}