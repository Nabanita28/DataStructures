package dataStructuresPractice.arrays;

import java.util.HashMap;
import java.util.Map;
//John’s clothing store has a pile of n loose socks where each sock i is labeled with an integer, ci, denoting its color. He wants to sell as many socks as possible, but his customers will only buy them in matching pairs. Two socks, i and j, are a single matching pair if ci = cj.
//Given n and the color of each sock, how many pairs of socks can John sell?
public class SockMerchant {
    public static void main(String[] args) {
        int[] ar = new int[]{1,2,1,2,1,3,2};
        System.out.println(sockMerchant(ar.length, ar));
    }
    static int sockMerchant(int n, int[] ar) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
           if(map.containsKey(ar[i])){
               map.put(ar[i], map.get(ar[i]) + 1);
            }
           else{
               map.put(ar[i], 1);
           }
        }
        int pairs = 0;
        for(Map.Entry entry : map.entrySet()){
            pairs = pairs + (int)entry.getValue() / 2;
        }
        return pairs;
    }
}
