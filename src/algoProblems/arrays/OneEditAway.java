package algoProblems.arrays;

public class OneEditAway {
    public static void main(String[] args) {
        String str1 = "1203";
        String str2 = "1213";
        System.out.println(isOneAway(str1, str2));
    }

    private static boolean isOneAway(String str1, String str2) {

        int m = str1.length();
        int n = str2.length();

        if (Math.abs(m-n) > 1) {
            return false;
        }
        int editCount = 0;
        int i=0, j=0;

        if(m == n){
            while(i<m && j<n){
                if(str1.charAt(i) != str2.charAt(j)){
                    editCount++;
                }
                i++; j++;
            }
        }else{
            while(i < m && j < n){
                if(str1.charAt(i) != str2.charAt(j)){
                    editCount++;
                    if (m > n) {
                        i++;
                    } else {
                        j++;
                    }
                }else{
                    i++; j++;
                }

            }

        }

        System.out.println("Edit count = " + editCount);
        return editCount > 1 ? false : true;
    }
}
