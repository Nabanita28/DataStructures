package dataStructuresPractice.arrays.mustDo;

import java.util.*;

public class BiggestNumberFromArray {
    public static void main(String[] args) {
        List<String> numbers = new ArrayList<>(Arrays.asList("54", "546", "548", "60"));
        findBiggestNumber(numbers);

    }

    private static void findBiggestNumber(List<String> numbers) {

        Collections.sort(numbers,(x1, x2) -> {
                return x1.compareTo(x2) > 0 ? -1 : 1;
            }
        );
        System.out.println("The biggest number from the given array is : ");
        for (String s : numbers)
            System.out.print(s);
        System.out.println();
    }
}
