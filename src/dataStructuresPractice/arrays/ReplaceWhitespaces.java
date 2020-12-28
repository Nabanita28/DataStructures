package dataStructuresPractice.arrays;

public class ReplaceWhitespaces {

    public static void main(String[] args) {
        replaceWhiteSpaces("Mr. Rajeev Ranjan                        ", 20);
    }

    private static void replaceWhiteSpaces(String str, int trueLength) {
        int spaceCount=0, i, index = 0;
        for(i=0; i<trueLength; i++){
            if(str.charAt(i) == ' '){
                spaceCount++;
            }
        index = trueLength + spaceCount * 2;

        }
        System.out.println(str.substring(0, index));
    }
}
