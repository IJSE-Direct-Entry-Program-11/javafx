package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class AnchorPaneLayoutSceneController {
    public Button btnClickMe;
    public AnchorPane root;

    public void btnClickMeOnAction(ActionEvent actionEvent) {
        double x = Math.random() * (root.getWidth() - btnClickMe.getWidth());
        double y = Math.random() * (root.getHeight() - btnClickMe.getHeight());

        btnClickMe.setLayoutX(x);
        btnClickMe.setLayoutY(y);
    }
}
