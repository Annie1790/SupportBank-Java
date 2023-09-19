package supportbank.Transaction;

public class Transaction {
    String date;
    String from;
    String to;
    String narrative;
    float amount;

    public Transaction(String date, String from, String to, String narrative, float amount) {
        this.date = date;
        this.from = from;
        this.to = to;
        this.narrative = narrative;
        this.amount = amount;
    }

}
