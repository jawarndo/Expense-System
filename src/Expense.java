public class Expense {

    private double amount;
    private String category;
    private String desc;

    Expense(double amount, String category, String desc) {
        this.amount = amount;
        this.category = category;
        this.desc = desc;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getDesc() {
        return desc;
    }
}
