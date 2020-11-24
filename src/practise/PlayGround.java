package practise;

import java.util.HashMap;
import java.util.Map;

public class PlayGround {
    public static void main(String[] args) {
        long start = System.nanoTime();

        System.out.println(fibonaci(25));

        long end = System.nanoTime();

        System.out.println(end - start);
    }

    static Map<Integer, Long> alreadyCalculated = new HashMap<>();

    static long fibonaci(int n) {

        if (n <= 1){
            return n;
        }

        if(alreadyCalculated.containsKey(n)){
            return alreadyCalculated.get(n);
        }


        long answer = fibonaci(n-1) + fibonaci(n-2);
        System.out.print( n + " ");
        alreadyCalculated.put(n, answer);

        return answer;
    }
}
