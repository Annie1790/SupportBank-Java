package supportbank.CsvScanner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import supportbank.Account.Account;
import supportbank.Transaction.Transaction;

public class CsvScanner {
    ArrayList<List<String>> utilityArr = new ArrayList<>();

    ArrayList<Transaction> transactionList = new ArrayList<>();

    public ArrayList<Transaction> scanCsv() throws FileNotFoundException {
        final BufferedReader reader = new BufferedReader(
                new FileReader("/home/aniko/bootcamp/SupportBank-Java/Transactions2014.csv"));
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                utilityArr.add(Arrays.asList(values));
            }
            reader.close();

        } catch (IOException e) {
            System.out.println(e);
        }
        return transactionList;
    }

    public void createTransactionList() {
        for (List<String> segment : utilityArr) {
            if (segment.get(0).equals("Date")) {
                continue;
            }
            String date = segment.get(0);
            String from = segment.get(1);
            String to = segment.get(2);
            String narrative = segment.get(3);
            float amount = Float.parseFloat(segment.get(4));
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
                if (from.contains(givenName) || to.contains(givenName)) {
                    result += (segment.toString() + "\n");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        System.out.print(result);
    }

    public void listAll() {
        Map<String, Account> myMap = new HashMap<>();
        ArrayList<Account> accountList = new ArrayList<>();
        String result = "";
        try {
            this.scanCsv();
            this.createTransactionList();
            for (Transaction segment : transactionList) {
                if (myMap.containsKey(segment.getFrom())) {

                    continue;
                } else {
                    myMap.put(segment.getFrom(), new Account(segment.getFrom()));
                }
            }



        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

    }
}
