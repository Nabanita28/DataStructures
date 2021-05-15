package dataStructuresPractice.bitwise;

public class AddTwoNumbers {
    public static void main(String[] args) {
        System.out.println(addTwoNumbers(5, 3));
    }

    static int addTwoNumbers(int x, int y){

        while( y != 0){

            int carry = x&y;

            x = x^y;

            y = carry << 1;
        }
        return x;
    }
}
