package supportbank.Transaction;

public class Transaction {
    String date;
    String from;
    String to;
    String narrative;
    double amount;

    public Transaction(String date, String from, String to, String narrative, double amount) {
        this.date = date;
        this.from = from;
        this.to = to;
        this.narrative = narrative;
        this.amount = amount;
    }

    public String toString() {
        return this.date + " " + this.from + " " + this.to + " " + this.narrative + " " + this.amount;
    }

    public String getFrom() {
        return this.from;
    }

    public String getTo() {
        return this.to;
    }

    public double getAmount() {
        return this.amount;
    }
}
