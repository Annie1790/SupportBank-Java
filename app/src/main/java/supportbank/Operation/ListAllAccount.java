package supportbank.Operation;

import supportbank.Account.AccountSystem;
import supportbank.Transaction.Transaction;

public class ListAllAccount implements OpInterface {
    AccountSystem accounts = new AccountSystem();

    @Override
    public void execute(Transaction transaction) {
        accounts.addAccount(transaction.getFrom());
        accounts.addAccount(transaction.getTo());
        accounts.createTransaction(transaction.getFrom(), transaction.getTo(), transaction.getAmount());
        accounts.printResult();
    }

}
