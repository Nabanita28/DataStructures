package dataStructuresPractice.math;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(7));
    }

    public static boolean isHappy(int n) {

        char[] num = String.valueOf(n).toCharArray();
        int sum = 0;

        while( sum != 1){
            sum = 0;
            for(int i=0; i<num.length; i++){
                sum = sum + (num[i] - '0')*(num[i] - '0');
            }

            if(sum == n){
                return false;
            }
            num = String.valueOf(sum).toCharArray();

        }
        return true;
    }
}
