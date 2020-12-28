package dataStructuresPractice.strings.mustDo;

public class RemoveAdjacentDuplicatesRecursively {
    public static void main(String[] args) {
        String str = "acaaabbbacdddd";
        System.out.println(removeAdjacentDuplicatesRecursively(str));
    }

    //TODO - need to revisit
    private static String removeAdjacentDuplicatesRecursively(String str) {
        char lastRemoved = '\0';
        return removeUtil(str, lastRemoved);
    }

    private static String removeUtil(String str, char lastRemoved) {
        if (str.length() == 0 || str.length() == 1)
            return str;

        if (str.charAt(0) == str.charAt(1)){
            lastRemoved = str.charAt(0);
            while(str.length() > 1 && str.charAt(0) == str.charAt(1))
                str = str.substring(1, str.length());
            str = str.substring(1, str.length());
            return removeUtil(str, lastRemoved);
        }

        String rem_str = removeUtil(str.substring(1, str.length()), lastRemoved);
        // Check if the first character of the rem_string matches with the first character of the original string
        if (rem_str.length() != 0 && str.charAt(0) == rem_str.charAt(0)){
            return rem_str.substring(1, rem_str.length());
        }
        /* If remaining string becomes empty and last removed character
             is same as first character of original string. This is needed
             for a string like "acbbcddc" */
        if (rem_str.length() == 0 && lastRemoved == str.charAt(0)){
            return rem_str;
        }

            return  str.charAt(0) + rem_str;
    }

}
