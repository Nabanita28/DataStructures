package arrays;

public class ReplaceWhitespaces {

    public static void main(String[] args) {
        replaceWhiteSpaces("Mr. Rajeev Ranjan                        ".toCharArray(), 20);
    }

    private static void replaceWhiteSpaces(char[] str, int trueLength) {
        int spaceCount=0, i, index = 0;
        for(i=0; i<trueLength; i++){
            if(str[i] == ' '){
                spaceCount++;
            }
        index = trueLength + spaceCount * 2;

        }
    }
}
