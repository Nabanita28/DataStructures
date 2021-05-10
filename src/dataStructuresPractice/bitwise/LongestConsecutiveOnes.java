package dataStructuresPractice.bitwise;

public class LongestConsecutiveOnes {
    public static void main(String[] args){
        System.out.println(maxConsecutiveOnes(927));
    }
    public static int maxConsecutiveOnes(int N) {

        int max_count = Integer.MIN_VALUE;
        int count = 0;
        while(N > 0){
            if((N & 1) == 1){
                count++;
            } else{
                count = 0;
            }
            max_count = Math.max(count, max_count);
            N = N>>1;
        }

        return max_count;
    }
}
