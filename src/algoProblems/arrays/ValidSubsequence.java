package algoProblems.arrays;

import java.util.Arrays;
import java.util.List;

public class ValidSubsequence {
    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(1,1,6,1);
        List<Integer> sequence = Arrays.asList(1,6,1);
        System.out.println(isValidSubsequence(array, sequence));
    }
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {

        int i=0, j=0;

        while(i<array.size() && j<sequence.size()){
            if(array.get(i) == sequence.get(j)){
                i++;
                j++;
            } else{
                i++;
            }
        }
        //If all characters of sequence were found in the array
        return (j == sequence.size());
    }
}
