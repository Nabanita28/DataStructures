package practise;

import java.util.Arrays;

public class PlayGround {
    public static void main(String[] args) {
        String s = "I am the best-developer";

        String[] input = s.split(" ");
        Arrays.stream(input).forEach(item-> System.out.print(item + " "));

        String[] input2 = s.split("\\W");
        Arrays.stream(input2).forEach(item-> System.out.print(item + " "));

        System.out.println("\n------------------\n");
        System.out.println(String.join(",", input));
        System.out.println(String.join(",", input2));

    }



}
