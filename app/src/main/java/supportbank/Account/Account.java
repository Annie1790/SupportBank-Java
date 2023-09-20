package supportbank.Account;

import java.util.HashMap;
import java.util.Map;

public class Account {
    Map<String, Account> myMap = new HashMap<>();
    
    private String name;
    private double money;

    public Account(String name) {
        this.name = name;
        this.money = 0;
    }

    public void addMoney(double amount) {
        this.money += amount;
    }

    public void subtractMoney(double amount) {
        this.money -= amount;
    }

    public String getName() {
        return this.name;
    }

    public double getMoney() {
        return this.money;
    }

    public String toString() {
        return this.name + this.money;
    }
}
