package dataStructuresPractice.practise;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int[] digits = new int[]{0, 0};
        int[] result = plusOne(digits);
        Arrays.stream(result).forEach(s -> System.out.print(s + " "));
    }

    public static int[] plusOne(int[] digits) {

        String s = "";

        for (int i = 0; i < digits.length; i++) {
            s = s + digits[i];
        }
        System.out.println(s);
        long number = Long.parseLong(s);
        number = number + 1;
        System.out.println(number);

        if (number < 10 && digits.length > 1) {
            s = '0' + String.valueOf(number);
        } else {
            s = String.valueOf(number);
        }

        int[] result = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            result[i] = s.charAt(i) - '0';
        }

        return result;
    }
}
