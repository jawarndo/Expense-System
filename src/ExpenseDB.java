import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseDB {

    private ArrayList<Expense> expenseArrayList;
    private String fileContents = "";
    private final String PATH = "/Users/jawarneh/Documents/Projects/Expense-System/storage/storage.txt";

    /*
    * Constructor only read files and populates array list.
     */
    ExpenseDB() {
        expenseArrayList = readDB();
    }

    /*
    * Adds an expense to the expenseArrayList which is then appended
      to the database.
    *
    * @params e: Expense object that will be added to the DB.
     */
    public void addExpense(double amount, String category, String desc) {
        // Append the Expense data to a new Expense object.
        expenseArrayList.add(new Expense(amount, category, desc));
        // Save updated the object back into the storage file.
        writeDB();
    }

    /*
    * Method reads the contents of the database then parses it
      such that all records are stored into the expenseArrayList.
    *
    * @return instance of ArrayList containing instances of Expense.
     */
    private ArrayList<Expense> readDB() {
        String contents = "";
        ArrayList<Expense> parsedExpenses = new ArrayList<>();

        // Wrap scanner in case of failure to site the file.
        try (Scanner scanner = new Scanner(new FileReader(this.PATH))) {
            // Appends file contents to variable.
            while (scanner.hasNextLine()) {
                contents += scanner.nextLine() + "\n";
            }
            // Save current file contents.
            fileContents = contents;
        } catch (FileNotFoundException e) {
            // Print errors for developer for now.
            e.printStackTrace();
        }

        // Parse contents into array list.
        String[] parsedContent = contents.split("\n");
        for (String itemCollection : parsedContent) {
            String[] items = itemCollection.split(",");
            parsedExpenses.add(new Expense(Double.parseDouble(items[0]), items[1], items[2]));
        }

        return parsedExpenses;
    }

    /*
    * Method that writes to the file specified by the PATH
      constant.
     */
    private void writeDB() {
        // Wrap a try statement in case writing fails.
        try(FileWriter fileWriter = new FileWriter(this.PATH)) {
            // Reference most last element of array list.
            Expense e = expenseArrayList.remove(expenseArrayList.size() - 1);
            // Append current contents plus the new Expense object.
            fileWriter.write(fileContents + String.format(
                    "%.2f,%s,%s,\n",
                    e.getAmount(),
                    e.getCategory(),
                    e.getDesc()
            ));
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Expense> getExpenseArrayList() {
        return expenseArrayList;
    }
}
