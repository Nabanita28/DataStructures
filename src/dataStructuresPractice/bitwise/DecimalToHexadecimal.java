package dataStructuresPractice.bitwise;

public class DecimalToHexadecimal {

    public static void main(String[] args) {
        int number = -1;
        System.out.println(convertDecimalToHexaDecimal(number));
    }

    static String convertDecimalToHexaDecimal(int num){

        StringBuilder result = new StringBuilder();
        int count = 0;
        char[] hex = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        while(count < 8 && num != 0){

            result.append(hex[num & 15]);
            count++;
            num = num >> 4;

        }
        return result.reverse().toString();

    }
}
