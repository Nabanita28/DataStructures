package arrays;

public class OneAway {
    public static void main(String[] args) {
        //System.out.println(isOneAway("pale", "palse"));
        String s1 = "pale";
        String s2 = "palse";
        System.out.println("Is One Away : " + isOneAway(s1, s2));
    }

    private static boolean isOneAway(String s1, String s2) {
        int i = 0;
        int j = 0;
        int m = s1.length();
        int n = s2.length();
        int count = 0;

        if (Math.abs(m - n) > 1) {
            return false;
        }
        while (i < m && j < n) {

            if (s1.charAt(i) != s2.charAt(j)) {
                if (count == 1)
                    return false;
                // If length of one string is more, then only possible edit is to remove a character
                if (m > n) {
                    i++;
                } else if (n > m) {
                    j++;
                } else {
                    i++;
                    j++;
                }

                count++;
            } else {
                i++;
                j++;
            }
        }
        if (i < m || j < n) {
            count++;
        }
        return count == 1;
    }
}
