package supportbank.CsvScanner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import supportbank.Transaction.Transaction;

public class CsvScanner {
    ArrayList<List<String>> utilityArr = new ArrayList<>();
    ArrayList<Transaction> transactionList = new ArrayList<>();

    public ArrayList<Transaction> scanCsv() throws FileNotFoundException {
        final BufferedReader reader = new BufferedReader( new FileReader("/home/aniko/bootcamp/SupportBank-Java/Transactions2014.csv"));
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                utilityArr.add(Arrays.asList(values));
            }
            reader.close();
            System.out.println(utilityArr);

            for (List<String> segment : utilityArr) {
                transactionList.add(new Transaction(segment.get(0), segment.get(1), segment.get(2), segment.get(3), 0));
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        return transactionList;
    }

    public void listAll() {
        try {
            ArrayList<Transaction> transactionList = this.scanCsv();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
