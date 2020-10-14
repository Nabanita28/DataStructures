package general;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = { 13, 7, 6, 45, 21, 9, 101, 102 };

        Arrays.sort(arr);
        Arrays.stream(arr).forEach(s-> System.out.print(s + " "));
    }
    }
