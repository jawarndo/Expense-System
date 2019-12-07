import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

public class MenuScene {

    private int width;
    private int height;

    private Scene scene;
    private Group root;

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
        // Initialise the layout object and scene.
        root = new Group();
        scene = new Scene(root, w, h, Color.LIGHTBLUE);
    }

    public Scene getScene() {
        return scene;
    }
}
