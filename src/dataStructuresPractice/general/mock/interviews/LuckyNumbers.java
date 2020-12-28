package dataStructuresPractice.general.mock.interviews;

public class LuckyNumbers {
    public static void main(String[] args) {
        System.out.println(checkIfLucky(5));
    }

    static int counter = 2;
//https://www.geeksforgeeks.org/lucky-numbers/
    private static boolean checkIfLucky(int n) {

        int next_position = n;

        if(counter > n){
            return true;
        }

        if(n % counter == 0){
            return false;
        }

        next_position = next_position - (next_position/counter);
        counter++;

        return checkIfLucky(next_position);
    }
}
