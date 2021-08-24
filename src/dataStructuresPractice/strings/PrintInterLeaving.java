package dataStructuresPractice.strings;

public class PrintInterLeaving {
    public static void main(String[] args) {
        String s1 = "AB"; // String 1
        String s2 = "CD"; // String 2

        printInterLeaving(s1, 0, s2, 0, "");
    }
    static void printInterLeaving(String s1, int i,
                                  String s2, int j,
                                  String asf)
    {
        if (i == s1.length() && j == s2.length()) {
            System.out.println(asf);
        }

        // Either we will start with string 1
        if (i < s1.length())
            printInterLeaving(s1, i + 1, s2, j,
                    asf + s1.charAt(i));
        // Or with string 2
        if (j < s2.length())
            printInterLeaving(s1, i, s2, j + 1,
                    asf + s2.charAt(j));
    }
}
