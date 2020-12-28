package dataStructuresPractice.strings.mustDo;

public class StringPermutations {
    public static void main(String[] args) {
        String s = "abc";
        permutation(s,"");
    }

    private static void permutation(String str, String permutation) {
        if(str.length() == 0){
            System.out.println(permutation);

        }
        else{
            for(int i =0; i<str.length(); i++){
                String ros = str.substring(0, i) + str.substring(i+1);
                permutation(ros, permutation + str.charAt(i));

            }
        }
    }
}
