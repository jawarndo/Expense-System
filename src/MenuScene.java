import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MenuScene {

    // Window Dimensions.
    private int width;
    private int height;

    // Scene objects.
    private Scene scene;
    private Group root;

    // Components/Prompts.
    private Label titleLabel;
    private Label editLabel;
    private Label analysisLabel;
    private Label tickLabel;

    // Text & BG Color
    private final Color bgColor = Color.rgb(46, 44, 44);
    private final Color textColor = Color.WHITE;

    // Flag to decide which mode is currently selected.
    private boolean isEdit = true;

    /*
    * Draws relevant labels and buttons
      onto the window.
    *
      @param w: width for width constraint.
      @param h: height for height constraint.
     */
    MenuScene(int w, int h) {
        this.width = w;
        this.height = h;
        // Initialise the layout object and all its nodes.
        root = new Group();
        // Init objects and set text.
        titleLabel = new Label("Expense Tracker");
        editLabel = new Label("  Edit\nExpenses");
        analysisLabel = new Label("Analyse\nExpenses");
        tickLabel = new Label("X");
        // Style text with Font class.
        titleLabel.setFont(Font.font("Chalkduster", 40));
        editLabel.setFont(Font.font("Chalkduster", 30));
        analysisLabel.setFont(Font.font("Chalkduster", 30));
        tickLabel.setFont(Font.font("Chalkduster", 40));

        titleLabel.setTextFill(textColor);
        editLabel.setTextFill(textColor);
        analysisLabel.setTextFill(textColor);
        tickLabel.setTextFill(textColor);

        // Position Labels.
        titleLabel.setLayoutX(62);
        titleLabel.setLayoutY(50);

        editLabel.setLayoutX(80);
        editLabel.setLayoutY(170);

        analysisLabel.setLayoutX(80);
        analysisLabel.setLayoutY(320);
        analysisLabel.setOpacity(0.5f);

        tickLabel.setLayoutX(350);
        tickLabel.setLayoutY(180);
        // Add all objects.
        root.getChildren().addAll(titleLabel, editLabel, analysisLabel, tickLabel);

        // Instantiate scene.
        scene = new Scene(root, w, h, bgColor);

        scene.setOnKeyReleased((KeyEvent e) -> {
            switch(e.getCode()) {
                case DOWN:
                case UP:
                    // Toggle between menu's.
                    if(isEdit) {
                        isEdit = false;
                        tickLabel.setLayoutY(analysisLabel.getLayoutY() + 20);
                        editLabel.setOpacity(0.5f);
                        analysisLabel.setOpacity(1.0f);
                    }
                    else {
                        isEdit = true;
                        tickLabel.setLayoutY(editLabel.getLayoutY());
                        editLabel.setOpacity(1.0f);
                        analysisLabel.setOpacity(0.5f);
                    }
                    break;
                case ENTER:
                    if(isEdit) {
                        Main.switchToEdit();
                    } else {
                        Main.switchToAnalysis();
                    }
                    break;
            }
        });
    }

    public Scene getScene() {
        return scene;
    }
}
