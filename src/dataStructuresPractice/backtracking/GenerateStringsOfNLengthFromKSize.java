package dataStructuresPractice.backtracking;

public class GenerateStringsOfNLengthFromKSize {
    public static void main(String[] args) {
        int n = 2;
        int k = 3;
        int[] output = new int[n];
        generateStringsOfNLengthFromKSize(n, k, output);
    }

    private static void generateStringsOfNLengthFromKSize(int n, int k, int[] output) {

        if(n == 0){
            for(int x : output)
                System.out.print(x + " ");
            System.out.println();
        }else{
            for(int i=0; i<k; i++){
                output[n-1] =  i;
                generateStringsOfNLengthFromKSize(n-1, k, output);
            }

        }
    }

}
