package strings;

public class RemoveOuterParenthesis {
    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())"));
    }

    public static String removeOuterParentheses(String S) {


        StringBuilder output = new StringBuilder();
        int count = 0;

        for(int i=0; i<S.length(); i++){
            if('(' == S.charAt(i) && count++ > 0){
                output.append(S.charAt(i));
            }
            if(')' == S.charAt(i) && --count > 0){
                output.append(S.charAt(i));
            }
        }

        return output.toString();
    }
}
