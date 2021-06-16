package dataStructuresPractice.practise;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;

public class JavaBigDecimal {
    public static void main(String[] args) {
        String[] s = {"9", "-100", "50", "0", "56.6", "90", "0.12", ".12"};

        Arrays.sort(s, Collections.reverseOrder((a,b) -> {

            if(a==null || b==null){
                return 0;
            }

            BigDecimal bigA = new BigDecimal(a);
            BigDecimal bigB = new BigDecimal(b);
            return bigA.compareTo(bigB);
        }));

        for(int i=0;i<s.length;i++)
        {
            System.out.print(s[i] + " ");
        }
    }
}
