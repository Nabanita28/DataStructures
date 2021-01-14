package algoProblems.strings;

public class MaxNumberByInsertingADigit {
    public static void main(String[] args) {
        System.out.println(findMAxNumberByInsertingADigit("-999", 5));
    }

    private static String findMAxNumberByInsertingADigit(String number, int digit) {

        StringBuilder sb = new StringBuilder(number);
        int length = number.length();

        for (int i = 0; i < length; i++) {
            if (sb.charAt(0) != '-') {
                if ((sb.charAt(i) - '0') > digit) {
                    sb.insert(i + 1, digit);
                } else {
                    sb.insert(i, digit);
                }
                break;
            } else {
                if (sb.charAt(i) < digit) {
                    sb.insert(i, digit);
                } else {
                    sb.insert(i + 1, digit);
                }
                break;
            }
        }

        return sb.toString();
    }
}
