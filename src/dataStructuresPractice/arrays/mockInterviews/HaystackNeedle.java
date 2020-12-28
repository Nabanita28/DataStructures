package dataStructuresPractice.arrays.mockInterviews;

public class HaystackNeedle {
    public static void main(String[] args) {
        String text = "BACDGABCDA";
        String pattern = "ABCD";
        findIndexOfNeedleInHaystack(text, pattern);
    }
//TODO - need to revisit
    static final int MAX = 256;
    private static void findIndexOfNeedleInHaystack(String text, String pattern) {

        int textLength = text.length();
        int patLength = pattern.length();

        char[] textArr = new char[MAX];
        char[] patArr = new char[MAX];

        for (int i=0; i<patLength; i++){
            textArr[text.charAt(i)]++;
            patArr[pattern.charAt(i)]++;
        }

        for (int j=patLength; j<textLength; j++){
            if (compare(textArr, patArr))
                System.out.println("Found at : " + (j - patLength));

            textArr[text.charAt(j)]++;
            textArr[text.charAt(j-patLength)]--;
        }

        if (compare(textArr, patArr))
            System.out.println("Found at : " + (textLength - patLength));

    }

    private static boolean compare(char[] textArr, char[] patArr) {
        for (int i=0; i<MAX; i++){
            if (textArr[i] != patArr[i])
                return false;
        }
        return true;
    }
}
