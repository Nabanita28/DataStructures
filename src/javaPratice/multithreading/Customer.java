package javaPratice.multithreading;

public class Customer implements Runnable{

    @Override
    public void run(){
        Bank bank = Bank.INSTANCE;
        BankAccount bankAccount = bank.getAccount(123456);
        synchronized (bankAccount){
            bankAccount.deposit(100);
            bankAccount.withdraw(100);
        }
    }
}
