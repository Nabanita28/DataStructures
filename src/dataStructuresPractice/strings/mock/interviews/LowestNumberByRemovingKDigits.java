package dataStructuresPractice.strings.mock.interviews;

public class LowestNumberByRemovingKDigits {
    public static void main(String[] args) {
        String str = "4325043";
        findLowestNumberByRemovingKDigits(str, 3);
    }
        //Time Complexity: O(kn) , where k is the count of numbers to be removed and n is the length of string.
        //Space Complexity: O(1) as we are not using any extra space.
    private static void findLowestNumberByRemovingKDigits(String str, int k) {
        int len = str.length();

        StringBuilder sb = new StringBuilder(str);
        for (int j=0; j<k; j++){
            int i=0;
           // We will start iterating the number and we will see that the i+1 is smaller than it, so we will remove i.
            while(i<len-1 && sb.charAt(i) <= sb.charAt(i+1)){
                i++;
            }
            sb.delete(i, i+1);
        }
        System.out.println("Lowest Number By Removing K Digits is : " + sb.toString());
    }
}
