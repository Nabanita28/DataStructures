package dataStructuresPractice.bitwise.mock.interviews;

public class CountSetBits {
    public static void main(String[] args) {
        int n = 6;
        countTotalSetBits(n);
    }

    private static void countTotalSetBits(int n) {
        int count = 0;
        int m = 1;

        while (n>0) {
            int number = n;
            while (number > 0) {
                int result = number & m;
                if (result == 1) {
                    count++;
                }
                    number = number >> 1;
            }
            n--;
        }
        System.out.println(count);
    }
}
