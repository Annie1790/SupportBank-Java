package supportbank.Operation;

import supportbank.Transaction.Transaction;

public class ListPersonTransaction implements OpInterface {
    String name;

    public ListPersonTransaction(String name) {
        this.name = name;
    }

    @Override
    public void execute(Transaction transaction) {
        String result = "";

        if (transaction.getFrom().equals(name) || transaction.getTo().equals(name)) {
            result += (transaction.toString() + "\n");
        }

        System.out.println(result);
    }
    
}
