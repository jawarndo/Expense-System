import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;

public class EditScene {

    // Scene object.
    private Group root = new Group();
    private Scene scene;
    // Database to add/store new Expense entries.
    private ExpenseDB expenseDB;
    // Dimensions of the proposed window.
    private int width;
    private int height;
    // Labels.
    private Label columnNameTitle;
    // Text Fields.
    private TextField amountTextField;
    private TextField categoryTextField;
    private TextField descTextField;
    // Colour.
    private Color bgColor = Color.rgb(46, 44, 44);
    // Text Area.

    /*
      * Creates all forms to allow the user to enter
       new entries.

       @param w: width of window.
       @param h: width of height.
     */
    EditScene(int w, int h) {
        // assign values.
        width = w;
        height = h;
        // Instance of the database.
        expenseDB = new ExpenseDB();
        // Create column label.
        columnNameTitle = new Label("Amount (£)\t Category\tDescription");
        columnNameTitle.setFont(Font.font("Chalkduster", 20));
        columnNameTitle.setTextFill(Color.WHITE);
        columnNameTitle.setLayoutX(30);
        columnNameTitle.setLayoutY(20);
        root.getChildren().add(columnNameTitle);
        // Create Scene.
        scene = new Scene(root, w, h, bgColor);

        scene.setOnKeyReleased((KeyEvent e) -> {
            switch(e.getCode()) {
                case ESCAPE:
                    Main.switchToMenu();
                    break;
            }
        });

        generateListOfExpenses();
        generateFormAddExpense();
    }

    /*
    * Generate a list of labels that show the top 20 recent most transactions.
     */
    private void generateListOfExpenses() {
        ArrayList<Expense> expenseArrayList = expenseDB.getExpenseArrayList();

        // Starting positions of the labels.
        int x = 40;
        int y = 50;

        // Generate list.
        for(int i = expenseArrayList.size() - 1; i > 0; i--) {
            Label listItemLabel = new Label();
            // Get current expense object.
            // Condition to check if expense item is not null.
            if(expenseArrayList.get(i) != null) {
                Expense e = expenseArrayList.get(i);
                listItemLabel.setText(
                        String.format("%.2f\t\t%s\t%s", e.getAmount(), e.getCategory(), e.getDesc())
                );
            } else {
                listItemLabel.setText("");
            }
            listItemLabel.setLayoutX(x);
            listItemLabel.setLayoutY(y);
            listItemLabel.setFont(Font.font("Chalkduster", 20));
            listItemLabel.setTextFill(Color.WHITE);
            // Append label object to root.
            root.getChildren().add(listItemLabel);
            // Increase spacing.
            y += 20;
        }
    }

    /*
    * Generates field at the bottom to add new entries.
     */
    private void generateFormAddExpense() {
        Label addIconLabel = new Label("+");
        addIconLabel.setTextFill(Color.WHITE);
        addIconLabel.setFont(Font.font("Chalkduster", 20));
        addIconLabel.setOpacity(0.5);
        addIconLabel.setLayoutX(400);
        addIconLabel.setLayoutX(height - 40);

        addIconLabel.setOnMouseEntered((MouseEvent e) -> {
            addIconLabel.setOpacity(1.0f);
            scene.setCursor(Cursor.HAND);
        });

        addIconLabel.setOnMouseExited((MouseEvent e) -> {
            addIconLabel.setOpacity(0.5f);
            scene.setCursor(Cursor.DEFAULT);
        });

        addIconLabel.setOnMouseReleased((MouseEvent e) -> {
            double amount = Double.parseDouble(amountTextField.getText());
            String category = categoryTextField.getText();
            String desc = descTextField.getText();

            expenseDB.addExpense(amount, category, desc);
            generateListOfExpenses();
        });

        amountTextField.setLayoutX(10);
        amountTextField.setLayoutY(height - 40);
        amountTextField.setPrefSize(300, 70);

        categoryTextField.setLayoutX(100);
        categoryTextField.setLayoutY(height - 40);
        categoryTextField.setPrefSize(300, 70);

        descTextField.setLayoutX(10);
        descTextField.setLayoutY(height - 40);
        descTextField.setPrefSize(300, 70);

        root.getChildren().addAll(amountTextField, categoryTextField, descTextField, addIconLabel);
    }

    public Scene getScene() {
        return scene;
    }
}
