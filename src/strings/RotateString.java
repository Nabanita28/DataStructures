package strings;

public class RotateString {

    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        System.out.println(isRotation(s1, s2));
    }

    private static boolean isRotation(String s1, String s2) {
        if(s1.length() == s2.length() && s1.length()>0){
            String s1s1 = s1 + s1;
            return isSubstring(s2, s1s1);
        }
     return false;
    }

    private static boolean isSubstring(String s2, String s1s1) {
        return s1s1.contains(s2);
    }
}
