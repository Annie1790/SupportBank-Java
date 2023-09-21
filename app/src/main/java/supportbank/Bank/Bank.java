package supportbank.Bank;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import supportbank.Account.AccountSystem;
import supportbank.Operation.ListAllAccount;
import supportbank.Operation.ListPersonTransaction;
import supportbank.Operation.OpInterface;
import supportbank.Transaction.Transaction;

public class Bank {
    private static final int CLOUMN_DATE = 0;
    private static final int CLOUMN_FROM = 1;
    private static final int CLOUMN_TO = 2;
    private static final int COLUMN_NARRATIVE = 3;
    private static final int COLUMN_AMOUNT = 4;

    ArrayList<List<String>> csvLines = new ArrayList<>();

    ArrayList<Transaction> transactionList = new ArrayList<>();

    private void scanCsv(String fileToRead) throws FileNotFoundException {
        final BufferedReader reader = new BufferedReader(
                new FileReader(fileToRead));
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                csvLines.add(Arrays.asList(values));
            }
            reader.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private void createTransactionList() {
        for (List<String> segment : csvLines) {
            if (segment.get(CLOUMN_DATE).equals("Date")) {
                continue;
            }
            String date = segment.get(CLOUMN_DATE);
            String from = segment.get(CLOUMN_FROM);
            String to = segment.get(CLOUMN_TO);
            String narrative = segment.get(COLUMN_NARRATIVE);
            float amount = Float.parseFloat(segment.get(COLUMN_AMOUNT));
            transactionList.add(new Transaction(date, from, to, narrative, amount));
        }
    }

    private void createTransactionArray() {
        try {
            this.scanCsv("/home/aniko/bootcamp/SupportBank-Java/Transactions2014.csv");
            // this.scanCsv("/home/aniko/bootcamp/SupportBank-Java/DodgyTransactions2015.csv");
            this.createTransactionList();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    // code duplication
    // refactor the two functions
    // possible solution:
    // Command pattern?
    // the problem is that I can't pass functions as I would do in JavaScript,
    // instead I need to pass a parent class/interface
    // create 2 class with an interface
    // interface will have an execution method which has a transaction argument
    // for the 2 classes, I copy the right methods listed below
    // bank has one method, where I create 2 instance objects:
    // ListAllPersonAndBalance and ListPersonTransaction
    // the method above will have one argument: Operation interface
    // operation.executeCode(segment)
    //

    public void listPerson(String givenName) {
        createTransactionArray();
        String result = "";
        for (Transaction segment : transactionList) {
            String from = segment.getFrom();
            String to = segment.getTo();
            if (from.equals(givenName) || to.equals(givenName)) {
                result += (segment.toString() + "\n");
            }
        }
        System.out.print(result);
    }

    public void listAllAccountAndBalance() {
        createTransactionArray();
        AccountSystem accounts = new AccountSystem();
        for (Transaction segment : transactionList) {
            String from = segment.getFrom();
            String to = segment.getTo();

            accounts.addAccount(from);
            accounts.addAccount(to);

            accounts.createTransaction(from, to, segment.getAmount());
        }
        accounts.printResult();

    }

    public void executeAll(OpInterface face) {
        createTransactionArray();
        for (Transaction transaction : transactionList) {
            face.execute(transaction);
        }

    }
}
