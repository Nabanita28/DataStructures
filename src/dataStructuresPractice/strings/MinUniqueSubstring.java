package dataStructuresPractice.strings;

import java.util.Map;
import java.util.TreeMap;

public class MinUniqueSubstring {
    public static void main(String[] args) {
        System.out.println(solution("abaaba"));
    }

    public static int solution(String S) {
        TreeMap<String, Integer> freqMap = new TreeMap<>();

        for(int i=0; i<S.length(); i++){
            for(int j=i+1; j<=S.length(); j++){
                if(i!=j){
                    String sub = S.substring(i, j);
                    freqMap.put(sub, freqMap.getOrDefault(sub, 0)+1);
                }
            }
        }

        int minLen = Integer.MAX_VALUE;
        for(Map.Entry entry : freqMap.entrySet()){
            if((int)entry.getValue() == 1){
                minLen = Math.min(minLen, (String.valueOf(entry.getKey()).length()));
            }
        }
        return minLen;
    }
}
