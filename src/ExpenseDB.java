import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseDB {

    private ArrayList<Expense> expenseArrayList;
    private final String PATH = "/Users/jawarneh/Documents/Projects/Expense-System/storage/storage.txt";

    /*
    * Constructor only read files and populates array list.
     */
    ExpenseDB() {
        expenseArrayList = readDB();
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
        try(Scanner scanner = new Scanner(new FileReader(this.PATH))) {
            // Appends file contents to variable.
            while (scanner.hasNextLine()) {
                contents += scanner.nextLine() + "\n";
            }
        }
        catch (FileNotFoundException e) {
            // Print errors for developer for now.
            e.printStackTrace();
        }

        // Parse contents into array list.
        String[] parsedContent = contents.split("\n");
        for(String itemCollection : parsedContent) {
            String[] items = itemCollection.split(",");
            parsedExpenses.add(new Expense(Double.parseDouble(items[0]), items[1], items[2]));
        }

        return parsedExpenses;
    }

    private void writeDB() {

    }
}
