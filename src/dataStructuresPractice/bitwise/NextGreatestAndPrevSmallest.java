package dataStructuresPractice.bitwise;

public class NextGreatestAndPrevSmallest {
    public static void main(String[] args) {
        int num = 13948;
        System.out.println("Next Greater Number =  " + findNextGreaterNumber(num));
        System.out.println("Next Smaller Number = " + findNextPreviousNumber(num));
    }

    private static int findNextPreviousNumber(int n) {
        int num = n;
        int countOfZeroes = 0;
        int countOfOnes = 0;


        while((num & 1) == 1){
            countOfOnes++;
            num = num >> 1;
        }

        while((num & 1) == 0 && num != 0){
            countOfZeroes++;
            num = num>>1;
        }

        int p = countOfOnes + countOfZeroes;

        if(p == 32 || p == 0){
            return -1;
        }

        int b = ((~0) << (p + 1));

        n = n & b;
        int mask = (1 << (countOfOnes + 1)) - 1;
        n = n | (mask << (countOfZeroes - 1));
        return n;
    }

    static int findNextGreaterNumber(int n){
        int num = n;
        int countOfZeroes = 0;
        int countOfOnes = 0;

        while((num & 1) == 0 && num != 0){
            countOfZeroes++;
            num = num >> 1 ;
        }
        while((num & 1) == 1){
            countOfOnes++;
            num = num >> 1;
        }
        int p = countOfOnes + countOfZeroes;

        if(p == 31 || p == 0){
            return -1;
        }

        //flip the rightmost non-trailing 0 to 1
        n = n | (1<< p);

        //create mask of 0s
        int mask = ~((1<<p) - 1);
        n = n&mask;
        int b = (1 << (countOfOnes-1)) -1;
        n = n | b;
        return n;
    }
}
