package javaPratice.multithreading.fizzbuzz;

public class FizzBuzzThread extends Thread {

    String methodName;
    MultithreadedFizzBuzz multithreadedFizzBuzz;

    FizzBuzzThread(MultithreadedFizzBuzz multithreadedFizzBuzz, String methodName) {
        this.multithreadedFizzBuzz = multithreadedFizzBuzz;
        this.methodName = methodName;
    }

    @Override
    public void run() {
        if ("fizz".equals(methodName)) {
            try {
                multithreadedFizzBuzz.fizz();
            } catch (Exception ex) {
                //System.out.println("Exception caught in fizz method");
            }

        } else if ("buzz".equals(methodName)) {
            try {
                multithreadedFizzBuzz.buzz();
            } catch (Exception ex) {
               // System.out.println("Exception caught in buzz method");
            }
        } else if ("fizzBuzz".equals(methodName)) {
            try {
                multithreadedFizzBuzz.fizzBuzz();
            } catch (Exception ex) {
              //  System.out.println("Exception caught in fizzBuzz method");
            }
        } else if ("number".equals(methodName)) {
            try {
                multithreadedFizzBuzz.number();
            }
            catch (Exception e) {
               // System.out.println("Exception caught in number method");
            }
        }
    }
}
