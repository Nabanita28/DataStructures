package dataStructuresPractice.strings;

import java.util.Collections;
import java.util.stream.Collectors;

public class IsUnique {
    public static void main(String[] args) {
        String input = "nabanita";
        System.out.println(isStringUnique(input));
    }

    private static boolean isStringUnique(String input) {

      return input.chars().filter(e -> Collections.frequency(input.chars().boxed().collect(Collectors.toList()), e) > 1 ).count() > 1 ? true : false;
    }
}
