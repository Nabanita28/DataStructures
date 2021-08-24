package dataStructuresPractice.backtracking;

public class GenerateAllStringsOfNBits {
    public static void main(String[] args) {
        int[] output = new int[4];
        generateAllStringsOfNBits(output, 4, 0);
    }
    //Time complexity – O(2^n)
    private static void generateAllStringsOfNBits(int[] output, int n, int index) {

        //base case
        if(n == index){
            for(int x : output)
            System.out.print(x + " ");
            System.out.println();
        }

        else{
            output[index] = 1;
            generateAllStringsOfNBits(output, n, index+1);

            output[index] = 0;
            generateAllStringsOfNBits(output, n, index+1);
        }

    }
}
