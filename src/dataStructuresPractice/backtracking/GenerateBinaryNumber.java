package dataStructuresPractice.backtracking;

public class GenerateBinaryNumber {
    public static void main(String[] args) {
        int number = 5;
        int base = 2;
        for(int i=1; i<=number; i++)
            System.out.println(generateBinaryNumber(i, base));
    }

    private static int generateBinaryNumber(int num, int base) {
        String result = "";
        while(num != 0){
            result = (num % base) + result;
            num = num / base;
        }
        return Integer.parseInt(result);
    }
}
