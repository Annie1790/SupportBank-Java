package supportbank.Operation;

import supportbank.Transaction.Transaction;

public class ListPersonTransaction implements OpInterface {
    String name;

    public ListPersonTransaction(String name) {
        this.name = name;
    }

    @Override
    public void execute(Transaction transaction) {

        if (transaction.getFrom().equals(name) || transaction.getTo().equals(name)) {
            System.out.println(transaction.toString());
        }
    }
    
}
