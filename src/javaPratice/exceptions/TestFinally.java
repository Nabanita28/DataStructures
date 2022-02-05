package javaPratice.exceptions;

public class TestFinally {
    public static void main(String[] args) {
        TestFinally testFinally = new TestFinally();
        try{
            testFinally.divide(3, 0);
        } catch(RuntimeException re){
            System.out.println("Runtime Exception");
        } catch(Exception ex){
            System.out.println("Exception");
        } finally {
            System.out.println("Finally End");
        }
    }

    private void divide(int i, int j) {
        try{
            int c = i/j;
        } finally {
            System.out.println("Finally");
        }
    }
}
