package supportbank.Bank;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import supportbank.Account.AccountSystem;
import supportbank.Transaction.Transaction;

public class Bank {
    private static final int CLOUMN_DATE = 0;
    private static final int CLOUMN_FROM = 1;
    private static final int CLOUMN_TO = 2;
    private static final int COLUMN_NARRATIVE = 3;
    private static final int COLUMN_AMOUNT = 4;

    ArrayList<List<String>> csvLines = new ArrayList<>();

    ArrayList<Transaction> transactionList = new ArrayList<>();

    public void scanCsv() throws FileNotFoundException {
        final BufferedReader reader = new BufferedReader(
                new FileReader("/home/aniko/bootcamp/SupportBank-Java/Transactions2014.csv"));
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

    public void createTransactionList() {
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

    public void listPerson(String givenName) {
        String result = "";
        try {
            this.scanCsv();
            this.createTransactionList();
            for (Transaction segment : transactionList) {
                String from = segment.getFrom();
                String to = segment.getTo();
                if (from.equals(givenName) || to.equals(givenName)) {
                    result += (segment.toString() + "\n");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        System.out.print(result);
    }

    public void listAll() {
        AccountSystem accounts = new AccountSystem();
        try {
            this.scanCsv();
            this.createTransactionList();
            for (Transaction segment : transactionList) {
                String from = segment.getFrom();
                String to = segment.getTo();

                accounts.addAccount(from);
                accounts.addAccount(to);

                accounts.transaction(from, to, segment.getAmount());
            }
            System.out.println(accounts.toString());
            accounts.printResult();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

    }
}
