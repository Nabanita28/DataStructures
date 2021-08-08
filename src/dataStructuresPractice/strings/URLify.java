package dataStructuresPractice.strings;

public class URLify {
    public static void main(String[] args) {
        String s = "Mr Rajeev Ranjan     ";
        System.out.println(urlify(s.toCharArray(), 16));
    }

    static String urlify(char[] str, int trueLength){
    //count number of spaces
        int spaceCount = 0;
        int i=0;
    for(i=0; i<str.length; i++){
        if(str[i] == ' '){
            spaceCount++;
        }
    }
    while(str[i-1] == ' '){
        spaceCount--;
        i--;
    }

    //spaceCount*2 to accomodate space for "%20"
    int newLength = i + spaceCount*2;

    int index = newLength-1;

    char[] result = new char[newLength];

    for(int j=i-1; j>=0; j--){
        if (str[j] == ' '){
            result[index] = '0';
            result[index-1] = '2';
            result[index-2] = '%';
            index = index-3;
        }else{
            result[index] = str[j];
            index--;
        }
    }
    return new String(result);

    }
}
