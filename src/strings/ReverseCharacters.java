package strings;

public class ReverseCharacters {

    public static void main(String[] args) {
        System.out.println(reverseInteger(159));
    }

    public static int reverseInteger(int x) {

        StringBuilder result = new StringBuilder();

        while(x != 0){
            int a = x % 10;
            x = x / 10;
            result.append(a);
        }

        return Integer.parseInt(result.toString());
        }
    }

