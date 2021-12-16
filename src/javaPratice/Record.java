package javaPratice;

public class Record {
    public static void main(String[] args) {
     //   check((h, l) -> h.append(l).isEmpty(), 5);
    }

    private static void check(Tower tw, int height){
        if (tw.isTooHigh(height, 100))
            System.out.println("yes, too high");
            else
            System.out.println("No");

    }
}
