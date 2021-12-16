package javaPratice.multithreading;

public class PrintNNumbersUsingEvenAndOddThread {
    int n;
    int count = 1;

    PrintNNumbersUsingEvenAndOddThread(int n) {
        this.n = n;
    }

    void printOdd() {
        synchronized (this) {
            while (count < n) {
                while (count % 2 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException ex) {

                    }
                }
                System.out.println(count);
                count++;
                notify();
            }
        }
    }

    void printEven() {
        synchronized (this) {
            while (count < n) {
                while (count % 2 != 0) {
                    try {
                        wait();
                    } catch (InterruptedException ex) {
                    }
                }
                System.out.println(count);
                count++;
                notify();
            }

        }

    }

    public static void main(String[] args) {
        PrintNNumbersUsingEvenAndOddThread obj = new PrintNNumbersUsingEvenAndOddThread(10);
        Thread t1 = new Thread(() -> {
            obj.printEven();
        });
        Thread t2 = new Thread(() -> {
            obj.printOdd();
        });

        t1.start();
        t2.start();
    }
}
