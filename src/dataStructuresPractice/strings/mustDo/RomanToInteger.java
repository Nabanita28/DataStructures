package dataStructuresPractice.strings.mustDo;

public class RomanToInteger {
    public static void main(String[] args) {
        String romanNumber = "MCMIV";
        System.out.println(romanToInteger(romanNumber));
    }

    private static int romanToInteger(String romanNumber) {

        int sum = 0;
        int s1 = 0;
        int s2 = 0;
        for (int i = 0; i < romanNumber.length(); i++) {
            s1 = getValue(romanNumber.charAt(i));

            if (i + 1 < romanNumber.length()) {
                s2 = getValue(romanNumber.charAt(i + 1));

                if (s1 >= s2) {
                    sum += s1;
                } else if (s1 < s2) {
                    sum += s2 - s1;
                    i++;
                }
            } else {
                sum += s1;
            }
        }
        return sum;
    }

    private static int getValue(char c) {

        switch (c){
            case 'I' :
                return 1;
            case 'V' :
                return 5;
            case 'X' :
                return 10;
            case 'L' :
                return 50;
            case 'C' :
                return 100;
            case 'D' :
                return 500;
            case 'M' :
                return 1000;
        }
        return -1;
    }
}
