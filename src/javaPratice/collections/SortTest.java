package javaPratice.collections;

import java.util.Arrays;
import java.util.Comparator;

public class SortTest {
    public static void main(String[] args) {
        Comparator<Integer> numberComparator = (number1, number2) -> number2.compareTo(number1);
        Integer arr[] = {1,4,3,2};
        Arrays.sort(arr, numberComparator);
        for(Integer num : arr){
            System.out.print(num + " ");
        }
    }
}

