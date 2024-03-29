import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class ExpenseClient {

    private ExpenseDB expenseDB;

    ExpenseClient() {
        expenseDB = new ExpenseDB();
    }

    /*
    * Begins the interface with the user. Giving them options to choose.
     */
    public void start() {

        // Prompt user.
        System.out.println("CS1822 Expense-System | Main Menu");
        System.out.println("\n[0]: Edit Mode." +
                "\n[1]: Analysis Mode." +
                "\n[2]: Exit.");
        System.out.println("Enter your choice below.");
        System.out.print("> ");

        // Retrieve input.
        int input = new Scanner(System.in).nextInt();

        // Test input to branch to choice.
        switch(input) {
            case 0:
                edit();
                break;
            case 1:
                analysis();
                start();
                break;
            case 2:
                System.exit(0);
                break;
            default:
                System.err.println("\nEnter a valid choice.");
                start();
        }
    }

    private void edit() {
        // Prompt User.
        System.out.println("CS1822 Expense-System | Edit Mode");
        System.out.println("\n[0]: Display Expenses." +
                "\n[1]: Add Expense." +
                "\n[2]: Delete Expense." +
                "\n[3]: Main Menu.");
        System.out.println("Enter your choice below.");
        System.out.print("> ");

        // Retrieve user choice.
        int input = new Scanner(System.in).nextInt();

        switch(input) {
            case 0:
                displayExpenses();
                edit();
                break;
            case 1:
                addExpense();
                edit();
                break;
            case 2:
                deleteExpense();
                edit();
                break;
            case 3:
                start();
                break;
        }
    }

    private void displayExpenses() {

        // Get array list of expenses.
        ArrayList<Expense> expenseArrayList = expenseDB.getExpenseArrayList();

        // Prompt user.
        System.out.println("\nTotal Expenses: " + expenseArrayList.size());
        System.out.println("Index:\tAmount:\tCategory:\tDescription:\n");

        for (int i = expenseArrayList.size() - 1; i >= 0; i--) {
            Expense e = expenseArrayList.get(i);
            System.out.printf("[%d]: \t£%.2f\t %s\t\t%s\n", i, e.getAmount(), e.getCategory(), e.getDesc());
        }

        System.out.println("");
    }

    private void addExpense() {

        double amount;
        String category, desc;

        System.out.println("\nExpense Form:");

        System.out.print("\nEnter the amount spent: £");
        amount = new Scanner(System.in).nextDouble();

        System.out.print("\nEnter the category of this expense: ");
        category = new Scanner(System.in).nextLine();

        System.out.print("\nEnter a short description about the expense: ");
        desc = new Scanner(System.in).nextLine();

        expenseDB.addExpense(amount, category, desc);
        System.out.println("\nExpense DB Updated!");
    }

    private void deleteExpense() {

        ArrayList<Expense> currentList = expenseDB.getExpenseArrayList();

        // Prompt user.
        System.out.println("Delete Mode");
        displayExpenses();
        System.out.println("Enter index you would like to delete.");
        System.out.print("> ");

        int input = new Scanner(System.in).nextInt();

        expenseDB.deleteExpense(input);

        System.out.println("Entry Deleted.");
    }

    private void analysis() {

        ArrayList<Expense> expenseArrayList = expenseDB.getExpenseArrayList();

        System.out.println("CS1822 Expense-System | Analysis Mode");
        System.out.println("Statistics:");

        // Calculate total spent.
        double total = 0.0f;
        for (int i = 0; i < expenseArrayList.size(); i++) {
            Expense e = expenseArrayList.get(i);
            total += e.getAmount();
        }
        System.out.printf("\nTotal Expenses: £%.2f\n", total);

        // Print spending per category.
        HashSet<String> categorySet = new HashSet<>();
        HashMap<String, Double> categoryMap = new HashMap<>();
        for (int i = 0; i < expenseArrayList.size(); i++) {
            categorySet.add(expenseArrayList.get(i).getCategory());
        }
        for (String s : categorySet) {
            categoryMap.put(s, 0.0);
        }
        // Iterate through expenseArrayList increment counts of each category.
        for (Expense e : expenseArrayList) {
            categoryMap.put(e.getCategory(), categoryMap.get(e.getCategory()) + e.getAmount());
        }
        System.out.println();
        // Print Highest spend category.
        System.out.println("Expenditure Per Category:");
        for (String s : categorySet) {
            System.out.printf("%s: £%.2f\n", s, categoryMap.get(s));
        }
        System.out.println();

    }
}
