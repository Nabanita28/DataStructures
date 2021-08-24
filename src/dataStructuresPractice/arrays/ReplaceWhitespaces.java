package dataStructuresPractice.arrays;

public class ReplaceWhitespaces {

    public static void main(String[] args) {
        String text = "Mr. Rajeev Ranjan                        ";
        replaceWhiteSpaces(text.toCharArray(), 17);
        replaceWhiteSpaces(text);
    }

    private static void replaceWhiteSpaces(char[] str, int trueLength) {
        int spaceCount = 0;

        for(int i=0; i<trueLength; i++){
            if(str[i] == ' '){
                spaceCount++;
            }
        }

        int index = trueLength + (spaceCount*2);

        for(int i=trueLength-1; i>=0; i--){
            if(str[i] == ' '){
                str[index-1] = '0';
                str[index-2] = '2';
                str[index-3] = '%';
                index = index-3;
            }else{
                str[index-1] = str[i];
                index--;
            }
        }
        System.out.println(String.valueOf(str));
    }

    private static void replaceWhiteSpaces(String str){
        String result = str.trim();
        result = result.replaceAll("\\s", "%20");
        System.out.println("Replaced WhiteSpaces with trim() : " + result);
    }
}
