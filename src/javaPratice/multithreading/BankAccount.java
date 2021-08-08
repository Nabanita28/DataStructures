package javaPratice.multithreading;

public class BankAccount {
    private Integer accountNumber;
    private Integer balance;

    public  BankAccount(Integer accountNumber, Integer balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public BankAccount(Integer accountNumber){
        this(accountNumber, 0);
    }

    public Integer getAccountNumber(){
        return this.accountNumber;
    }
    public Integer getBalance(){
        return this.balance;
    }

    public Integer withdraw(Integer amount){
        if( balance < amount){
            System.out.println("Low Balance " + balance);
            return 0;
        }
        balance = balance - amount;
        System.out.println(Thread.currentThread().getName() + " Balance after withdrawing - " + balance);
        return balance;
    }
    public Integer deposit(Integer amount){
        System.out.println(Thread.currentThread().getName() + " Amount before depositing - " + balance);
        balance = balance + amount;
        System.out.println(Thread.currentThread().getName() + " Amount after depositing - " + balance);
        return balance;
    }
}
