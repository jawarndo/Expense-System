import java.util.ArrayList;
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
                break;
            case 1:
                addExpense();
                break;
            case 2:
                deleteExpense();
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

        for (int i = 0; i < expenseArrayList.size() ; i++) {
            System.out.printf("£%.2f");
        }
    }

    private void addExpense() {

    }

    private void deleteExpense() {

    }

    private void analysis() {

    }
}
