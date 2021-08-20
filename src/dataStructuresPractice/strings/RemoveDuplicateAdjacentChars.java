package dataStructuresPractice.strings;

public class RemoveDuplicateAdjacentChars {
    public static void main(String[] args) {
        System.out.println(remove("geeksforgeeg"));
    }

    static String remove(String str){
        return removeUtil(str, '\0');
    }

    private static String removeUtil(String str, char lastRemoved) {

        //base case
        if(str.length() == 0 || str.length() == 1){
            return str;
        }

        if (str.charAt(0) == str.charAt(1)){
            lastRemoved = str.charAt(0);
            while(str.charAt(0) == str.charAt(1)){
                str = str.substring(1, str.length());
            }
            str = str.substring(1, str.length());
            removeUtil(str, lastRemoved);
        }
        // At this point, the first
        // character is definiotely different
        // from its adjacent. Ignore first
        // character and recursively
        // remove characters from remaining string
        String remainingString = removeUtil(str.substring(1, str.length()), lastRemoved);

        if(remainingString.length() != 0 && str.charAt(0) == remainingString.charAt(0)){
            lastRemoved = str.charAt(0);
            return remainingString.substring(1, remainingString.length());
        }
        if(remainingString.length() == 0 && str.charAt(0) == lastRemoved){
            return remainingString;
        }

        return str.charAt(0) + remainingString;
    }

}
