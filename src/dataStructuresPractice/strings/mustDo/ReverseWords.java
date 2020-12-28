package dataStructuresPractice.strings.mustDo;

public class ReverseWords {
    public static void main(String[] args) {
        String s = "getting good at coding needs a lot of practice";
        String[] inputArray = s.split(" ");
        String ans = "";
        for (int i=inputArray.length-1; i>=0; i--){
            ans = ans + " " + inputArray[i];
        }
        System.out.println(ans);
    }
}
