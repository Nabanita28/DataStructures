package arrays;

public class OneAway {
    public static void main(String[] args) {
        //System.out.println(isOneAway("pale", "palse"));
        String s1 = "abc";
        String s2 = "abcd";
        System.out.println(s2.compareToIgnoreCase(s1));
    }

    // Adding test comment by Rajeev
    private static boolean isOneAway(String s1, String s2) {
        boolean flag = false;
        if (s1.length() != s2.length()) {
            if (s1.length() > s2.length() && s2.equalsIgnoreCase(s1.substring(0, s2.length()))) {
                if (s1.length() - s2.length() == 1) flag = true;
            } else if (s1.length() < s2.length() && s1.equalsIgnoreCase(s2.substring(0, s1.length()))) {
                if (s2.length() - s1.length() == 1) flag = true;
            }
        }
        return flag;
    }
}
