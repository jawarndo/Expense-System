import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    private static int width = 500;
    private static int height = 500;

    private static Stage stage;

    /*
    * Launch window, set initial menu scene.
    * @params stage: set the stage object.
     */
    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        this.stage.setTitle("Expense System");
        this.stage.setScene(new MenuScene(width, height).getScene());
        this.stage.setResizable(false);
        this.stage.show();
    }

    public static void switchToEdit() {
        stage.setTitle("Expense System | Edit");
        stage.setScene(new EditScene(width, height).getScene());
    }

    public static void switchToAnalysis() {
        stage.setTitle("Expense System | Analysis");
    }

    public static void switchToMenu() {
        stage.setTitle("Expense System");
        stage.setScene(new MenuScene(width, height).getScene());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
