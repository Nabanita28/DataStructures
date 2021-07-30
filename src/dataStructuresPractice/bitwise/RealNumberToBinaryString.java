package dataStructuresPractice.bitwise;

//Converting a Real Number (between 0 and 1) to Binary String

public class RealNumberToBinaryString {
    public static void main(String[] args) {
        System.out.println(convertRealNumberToBinaryString(0.625));
    }

    private static String convertRealNumberToBinaryString(double num) {

        StringBuilder sb = new StringBuilder();
        double fraction = 0.5;
        sb.append(".");
        while(num > 0){

            if(num >= fraction){
                sb.append(1);
                num = num - fraction;
            }else{
                sb.append(0);
            }
            fraction = fraction/2;
        }
        return sb.toString();
    }
}
