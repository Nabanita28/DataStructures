package bitwise;

public class binaryNumberCount {
    public static void main(String[] args){
        int num = 3;
        System.out.println("number with no consecutive 1 = " + countWithNoConsecutiveOnes(num));
        System.out.println("number with consecutive 1 = " + countWithConsecutiveOnes(num));

    }

    public static int countWithNoConsecutiveOnes(int n){
        int count = 0;
        int max = (1 << n);

        for(int i=0; i< max; i++){
            if(((i<<1) & i) == 0){
                count++;
            }
        }
        return count;
    }

    public static int countWithConsecutiveOnes(int n){
        int count = 0;
        int max = (1 << n);

        for(int i=0; i< max; i++){
            if(((i<<1) & i) != 0){
                count++;
            }
        }
        return count;
    }
}
