package dataStructuresPractice.strings;

public class CustomSortString {
    public static void main(String[] args) {
        System.out.println(customSortString("cbafg", "abcdd"));
    }

    public static String customSortString(String order, String str) {

        int[] count = new int[26];
        int[] countOrder = new int[26];


        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }

        for (int i = 0; i < order.length(); i++) {
            countOrder[order.charAt(i) - 'a']++;
        }

        char[] strArr = new char[str.length()];
        int index = 0;
        for (int i = 0; i < order.length(); i++) {
            for (int j = 0; j < count[order.charAt(i) - 'a']; j++) {
                strArr[index++] = order.charAt(i);
            }
        }

        for (int i = 0; i < str.length(); i++) {
            if (countOrder[str.charAt(i) - 'a'] == 0) {
                strArr[index++] = str.charAt(i);
            }
        }

        return new String(strArr);
    }
}
