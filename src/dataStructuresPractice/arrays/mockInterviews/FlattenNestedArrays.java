package dataStructuresPractice.arrays.mockInterviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlattenNestedArrays {
    public static void main(String[] args) {
        int[][][] arr = {
                {
                        {1,2,3},{4,5,6},{7,8,9}
                },
                {
                        {10,11,12},{13,14,15},{16,17,18}
                }
        };


        flattenArray(arr);

        //{{1,2, {3}},4};
    }

    private static void flattenArray(int[][][] arr) {

        List<Integer> flattenList = new ArrayList<>();

        for(int[][] array : arr){
            for (int[] array1D : array){
                Arrays.stream(array1D).forEach(flattenList::add);
            }
        }

        System.out.println(flattenList);
    }
}
