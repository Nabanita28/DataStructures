package javaPratice.multithreading;

public class BankTest {
    public static void main(String[] args) {
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        Thread thread1 = new Thread(customer1);
        Thread thread2 = new Thread(customer2);

        thread1.setName("Thread-1");
        thread2.setName("Thread-2");

        thread1.start();
        thread2.start();

    }
}
