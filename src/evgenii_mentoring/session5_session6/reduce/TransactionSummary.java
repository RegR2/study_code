package evgenii_mentoring.session5_session6.reduce;

public class TransactionSummary {
    private double total;
    private String type;

    public TransactionSummary() {
    }

    public TransactionSummary(double total, String type) {
        this.total = total;
        this.type = type;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
