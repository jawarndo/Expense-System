public class Expense {

    private double amount;
    private String category;
    private String desc;

    /*
    * Constructor only creates an object to store the
      collection of data.
    *
    * @param amount: is the amount of currency in GBP.
    * @param category: is a single word.
    * @param desc: short description of the transaction.
     */
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
