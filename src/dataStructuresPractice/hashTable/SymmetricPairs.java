package dataStructuresPractice.hashTable;

import java.util.HashMap;
import java.util.Map;

public class SymmetricPairs {
    public static void main(String[] args) {
        int[][] pairs = new int[][]{{1, 3},
                                    {5,3},
                                    {2,6},
                                    {3, 1},
                                    {6,2}};
        printSymmetricPairs(pairs);
    }

    static void printSymmetricPairs(int[][] pairs){
        Map<Integer, Integer> pairMap = new HashMap<>();

        for(int i=0; i<pairs.length; i++){

                int key = pairs[i][1];
                if(pairMap.containsKey(key)){
                    int val = pairMap.get(key);
                    if(val == pairs[i][0])
                    System.out.println("Pairs - (" + pairs[i][0] + "," + pairs[i][1] + ")" );
                }else{
                    pairMap.put(pairs[i][0], pairs[i][1]);
                }
            }
        }
}
