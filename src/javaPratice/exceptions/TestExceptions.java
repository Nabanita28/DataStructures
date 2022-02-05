package javaPratice.exceptions;

public class TestExceptions {
    public static void main(String[] args) {
        System.out.println(method());
    }
    static Object method(){
        try{
            int i = 10/0;
            return i;
        }catch(ArithmeticException ex){
            return "catch";
        }finally {
            return "finally";
        }
    }
}
