package dataStructuresPractice.arrays;

public class MaxIndexDifference {

    public static void main(String[] args) {
        int[] input = { 9, 2, 3, 4, 5, 6, 7, 8, 18, 0 };
        System.out.println("Max diff = " + findMaxDiff(input));
    }

    private static int findMaxDiff(int[] input) {
        int size = input.length;
        int maxDiff = 0;
        int[] leftMin = new int[size];
        int[] rightMax = new int[size];
        int lMin = input[0];

        for(int i=0; i<size; i++){
            if(i == 0){
                leftMin[i] = input[i];
            } else{
                if(input[i] < lMin ){
                    leftMin[i] = input[i];
                    lMin = input[i];
                } else{
                    leftMin[i] = leftMin[i-1];
                }
            }
        }

        rightMax[size-1] = input[size-1];
        int rMax = input[size-1];
        for(int i=size-2; i>=0; i--){
            if(input[i] < rMax ){
                rightMax[i] = rMax;
            } else{
                rightMax[i] = input[i];
                rMax = input[i];
            }

        }

        int i=0, j=0;

        while(i<size && j<size){
           while(j<size && leftMin[i] < rightMax[j]){
               maxDiff = Math.max(maxDiff,j-i);
               j++;
           }

           i++;
        }

        return maxDiff;
    }
}
