package arrays.mustDo;

import java.util.HashMap;
import java.util.Map;

public class FindPrime {
    public static void main(String[] args) {

       // findPrime(9999);
        printPrimeNumbers(20);
    }

    private static void findPrime(int n) {

        Map<Integer, String> map = new HashMap();
        for (int i = 0; i < n; i++) {
            map.put(i, "UNMARKED");
        }

        //for every number starting from p=2
        for (int p = 2; p * p <= n; p++) {
            if ("UNMARKED".equalsIgnoreCase(map.get(p))) {
                //for every multiple of p; if p=2, start from 2*2=4, mark multiples of p
                for (int i = p * p; i <= n; i = i + p) {
                    map.put(i, "MARKED");
                }
            }
        }

        for (Map.Entry entry : map.entrySet()) {
            if ("UNMARKED".equalsIgnoreCase(entry.getValue().toString()))
                System.out.println(entry.getKey());
        }
    }


    private static void printPrimeNumbers(int n) {

        boolean[] isNotPrime = new boolean[n+1];

        for(int i=2; i*i <= n; i++) {
            for (int j = i+i; j <= n; j = j + i) {
                isNotPrime[j] = true;
            }
        }
        for (int i=2; i<n; i++){
            if (!isNotPrime[i]){
                System.out.println(i);
            }
        }

    }
}

