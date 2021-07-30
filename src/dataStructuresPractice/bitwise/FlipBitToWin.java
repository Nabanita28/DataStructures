package dataStructuresPractice.bitwise;

public class FlipBitToWin {
    public static void main(String[] args) {
        System.out.println("Max Sequence length = " + flipBitToWin(1775));
    }

    private static int flipBitToWin(int num) {

        int currentLength = 0;
        int prevLength = 0;
        int maxLength = 1;

        while(num != 0){
            if((num & 1) == 1){
                currentLength++;
            }else{
                prevLength = (num & 2) == 0 ? 0 : currentLength;
                currentLength = 0;
            }
            num = num >> 1;
            maxLength = Math.max(1+ prevLength + currentLength, maxLength);
        }
    return maxLength;
    }
}
