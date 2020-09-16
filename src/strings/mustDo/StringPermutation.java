package strings.mustDo;

public class StringPermutation {

    public static void main(String[] args) {
        String s = "ABC";
        //TODO need to re-visit
        printPermutations(s, 0, s.length()-1);

    }

    private static void printPermutations(String str, int left, int right) {

        if (left == right)
            System.out.println(str.toString());

        else{
            for(int i=left; i<=right; i++){
             str = swap(str, left, i);
             printPermutations(str, left+1, right);
             str = swap(str, left, i);
            }
        }
    }

    private static String swap(String str, int left, int right){
        char[] c = str.toCharArray();

        char temp = c[left];
        c[left] = c[right];
        c[right] = temp;

        return String.valueOf(c);
    }
}
