package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;

public class StackPaneLayoutSceneController {
    public Circle shpCircle;
    public Button btnBringToFront;

    public void btnBringToFrontOnAction(ActionEvent actionEvent) {
        shpCircle.toFront();
    }
}
