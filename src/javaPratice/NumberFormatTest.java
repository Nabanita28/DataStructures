package javaPratice;

public class NumberFormatTest {

    public void test() {
        try {
            String number = "twenty";
            int twenty = Integer.parseInt(number);
            System.out.println(twenty);
        } catch (NumberFormatException ex) {
            System.out.println("Caught NumberFormatException");
        } catch (Exception ex) {
            System.out.println("Caught Exception");
        }
    }

    public static void main(String[] args) {
        NumberFormatTest nm = new NumberFormatTest();
        nm.test();
    }
}
