package dataStructuresPractice.bitwise;

public class MaskBits {
    public static void main(String[] args) {

        System.out.println(maskBits(2,6,1024, 19));
    }

    static int maskBits(int i, int j, int n, int m) {

       int allOnes = ~0;
       int leftMask = allOnes << (j+1);

       int rightMask = (1 << i) - 1;

       int mask = leftMask | rightMask;

       int cleared_n =  n & mask;
       int m_shift = m << i;

       return cleared_n | m_shift;

    }


    /*static long maskBits(int i, int j, int n, int m){
        int mask = createMask(i, j);

        int shift = mask << i;
        int maskedNumber = n | shift;
        m = m << i;
        maskedNumber = maskedNumber & m;
        System.out.println("test " + ~0);
        return maskedNumber;
    }

    static int createMask(int i, int j){
        int count = j-i;
        int mask = 1;
        while(count != 0){
            mask = mask<<1;
            mask = mask | 1;
            count--;
        }
        return mask;
    }*/
}
