package arrays;

public class StringCompression {
    public static void main(String[] args) {
        System.out.println(compressedString("aabcccccaaa"));
    }

    private static String compressedString(String s) {
        char[] c = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i = 0; i<c.length-1; i++) {
            char current = c[i];
            count = 1;
                while (i<c.length-1 && current == c[i + 1]) {
                    count++;
                    i++;
                }
            sb.append(c[i]).append(count);
            }

        if(sb.length() > s.length()){
            return s;
        } else {
            return sb.toString();
        }
    }

}
