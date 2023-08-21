package lk.ijse.dep11;

import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class MainSceneController {
    public Button btnFadeIn;
    public Button btnFadeOut;
    public Circle shpFade;
    public AnchorPane root;
    public Spinner<Integer> txtRotate;
    public Button btnRotate;
    public Rectangle shpRotate;

    public void initialize(){
        txtRotate.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(-360, 360));
        txtRotate.getValueFactory().setValue(45);
    }

    public void btnRotateOnAction(ActionEvent actionEvent) {
        RotateTransition rotate = new RotateTransition(Duration.millis(500), shpRotate);
        rotate.setFromAngle(0);
        rotate.setToAngle(txtRotate.getValue());
        rotate.playFromStart();
    }

    // Fade In (Hide -> Show)
    // Fade Out (Show -> Hide)
    public void btnFadeInOnAction(ActionEvent actionEvent) {
        FadeTransition fadeOut = new FadeTransition(Duration.millis(500), shpFade);
        fadeOut.setFromValue(0);        // <- opacity value
        fadeOut.setToValue(1);
        fadeOut.playFromStart();
    }

    public void btnFadeOutOnAction(ActionEvent actionEvent) {
        FadeTransition fadeOut = new FadeTransition(Duration.millis(500), shpFade);
        fadeOut.setFromValue(1);        // <- opacity value
        fadeOut.setToValue(0);
        fadeOut.playFromStart();
    }
}
