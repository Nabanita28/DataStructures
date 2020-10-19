package arrays.mockInterviews;

import java.util.ArrayList;
import java.util.List;

public class FindProductPairs {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        findProductPairs(arr, 6);
    }

    private static void findProductPairs(int[] arr, int x) {
        int len = arr.length;
        if (len < 2)
            return;
        List<Integer> list = new ArrayList<>();

        for (int i=0; i<len; i++) {
            if (x % arr[i] == 0) {
                if (list.contains(x / arr[i])) {
                    System.out.println(arr[i] + " " + (x / arr[i]));
                }
                else{
                    list.add(arr[i]);
                }
            }
        }
    }
}
