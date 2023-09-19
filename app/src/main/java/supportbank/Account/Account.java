package supportbank.Account;

public class Account {
    String name;
    float money;

    public Account(String name) {
        this.name = name;
        this.money = 0;
    }

    public void addMoney(float amount) {
        this.money += amount;
    }

    public void subtractMoney(float amount) {
        this.money -= amount;
    }

    
}
