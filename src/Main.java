import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    private static int width = 1000;
    private static int height = 800;

    /*
    * Launch window, set initial menu scene.
    * @params stage: set the stage object.
     */
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Expense System");
        //stage.setScene(someScene);
        stage.setResizable(false);
        stage.show();
    }

//    public static void main(String[] args) {
//        launch(args);
//    }
}
