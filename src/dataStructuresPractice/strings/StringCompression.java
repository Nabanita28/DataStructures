package dataStructuresPractice.strings;

public class StringCompression {
    public static void main(String[] args) {
        System.out.println(compressedString("aabcccccaaa"));
    }

    private static String compressedString(String str) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            count = 1;
            while (i < str.length() - 1 && current == str.charAt(i + 1)) {
                count++;
                i++;
            }
            sb.append(current).append(count);
        }

        if (sb.length() > str.length()) {
            return str;
        } else {
            return sb.toString();
        }
    }

}
