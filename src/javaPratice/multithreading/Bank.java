package javaPratice.multithreading;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    public final static Bank INSTANCE = new Bank();

    Map<Integer, BankAccount> account;

    public Bank(){
        this.account = new HashMap<>();
        account.put(123456, new BankAccount(123456));
    }

    public Bank getInstance(){
        return INSTANCE;
    }
    public BankAccount getAccount(Integer accountNumber){
        return this.account.get(accountNumber);
    }
}
