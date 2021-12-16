package javaPratice.multithreading.fizzbuzz;

public class MultithreadedFizzBuzz {

    int n;
    int num = 1;

    MultithreadedFizzBuzz(int n){
        this.n = n;
    }

    public void fizz() throws InterruptedException{
        synchronized (this){
            while(num <= n){
                if(num % 3 == 0 && num % 5 != 0){
                    System.out.println("Fizz");
                    num++;
                    notifyAll();
                }else{
                    wait();
                }
            }
        }

    }

    public void buzz() throws InterruptedException{
        synchronized (this) {
            while (num <= n) {
                if (num % 3 != 0 && num % 5 == 0) {
                    System.out.println("Buzz");
                    num++;
                    notifyAll();
                } else {
                    wait();
                }
            }
        }
    }

    public void fizzBuzz() throws InterruptedException{
        synchronized (this) {
            while (num <= n) {
                if (num % 3 == 0 && num % 5 == 0) {
                    System.out.println("FizzBuzz");
                    num++;
                    notifyAll();
                } else {
                    wait();
                }
            }
        }
    }

    public void number() throws InterruptedException{
        synchronized (this){
            while(num <= n) {
                if (num % 3 != 0 && num % 5 != 0) {
                    System.out.println(num);
                    num++;
                    notifyAll();
                } else {
                    wait();
                }
            }
            }
    }
}
