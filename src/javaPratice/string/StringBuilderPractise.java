package javaPratice.string;

public class StringBuilderPractise {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("ab#c");
        sb.delete(1, 3);
        System.out.println(sb.toString());
    }
}
