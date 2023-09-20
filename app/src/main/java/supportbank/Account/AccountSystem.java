package supportbank.Account;

import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;

public class AccountSystem {
    Map<String, Account> accountSystem = new HashMap<String, Account>();

    public void addAccount(String name) {
        accountSystem.put(name, new Account(name));
    }

    public void transaction(String from, String to, double amount) {
        Account personFrom = accountSystem.get(from);
        Account personTo = accountSystem.get(to);

        personFrom.subtractMoney(amount);
        personTo.addMoney(amount);
    }

    public void printResult() {
        for (Entry<String, Account> segment: accountSystem.entrySet()) {
            System.out.println(segment.getKey() + " " + segment.getValue().getMoney());
        }
    }

}
