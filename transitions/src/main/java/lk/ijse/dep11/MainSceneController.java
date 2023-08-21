package lk.ijse.dep11;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
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

    public Spinner<Double> txtScale;
    public Button btnScale;
    public Circle shpScale;

    public ComboBox<String> cbTranslate;
    public Button btnTranslate;
    public Rectangle shpTranslate;

    public ColorPicker clrFrom;
    public ColorPicker clrTo;
    public Button btnFill;
    public Circle shpFill;

    public Button btnStroke;
    public Rectangle shpStroke;
    public ColorPicker clrFromStroke;
    public ColorPicker clrToStroke;

    public void btnStrokeOnAction(ActionEvent actionEvent) {
        StrokeTransition stroke = new StrokeTransition(Duration.millis(2500), shpStroke);
        stroke.setFromValue(clrFromStroke.getValue());
        stroke.setToValue(clrToStroke.getValue());
        stroke.playFromStart();
    }

    public void btnFillOnAction(ActionEvent actionEvent) {
        FillTransition fill = new FillTransition(Duration.millis(2500), shpFill);
        fill.setFromValue(clrFrom.getValue());
        fill.setToValue(clrTo.getValue());
        fill.playFromStart();
    }

    public void btnTranslateOnAction(ActionEvent actionEvent) {
        TranslateTransition translate = new TranslateTransition(Duration.millis(500), shpTranslate);
        shpTranslate.setLayoutX(111);
        shpTranslate.setLayoutY(124);
        switch (cbTranslate.getValue()){
            case "SlideInLeft":
                translate.setFromX(-250);
                translate.setToX(0);
                break;
            case "SlideInRight":
                translate.setFromX(250);
                translate.setToX(0);
                break;
            case "SlideInUp":
                translate.setFromY(-250);
                translate.setToY(0);
                break;
            case "SlideInDown":
                translate.setFromY(250);
                translate.setToY(0);
                break;
            case "SlideOutLeft":
                translate.setFromX(0);
                translate.setToX(-250);
                break;
            case "SlideOutRight":
                translate.setFromX(0);
                translate.setToX(250);
                break;
            case "SlideOutUp":
                translate.setFromY(0);
                translate.setToY(-250);
                break;
            case "SlideOutDown":
                translate.setFromY(0);
                translate.setToY(250);
                break;
        }
        translate.playFromStart();
    }

    public void btnScaleOnAction(ActionEvent actionEvent) {
        ScaleTransition scale = new ScaleTransition(Duration.millis(500), shpScale);
        scale.setFromX(0);
        scale.setFromY(0);
        scale.setToX(txtScale.getValue());
        scale.setToY(txtScale.getValue());
        scale.playFromStart();
    }

    public void initialize(){
        txtRotate.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(-360, 360));
        txtRotate.getValueFactory().setValue(45);

        txtScale.setValueFactory(new SpinnerValueFactory
                                            // min,  max, initialValue,step
                .DoubleSpinnerValueFactory(-0.5, 1.8, 1.3, 0.1));

        cbTranslate.getItems().add("SlideInLeft");
        cbTranslate.getItems().add("SlideInRight");
        cbTranslate.getItems().add("SlideInUp");
        cbTranslate.getItems().add("SlideInDown");
        cbTranslate.getItems().add("SlideOutLeft");
        cbTranslate.getItems().add("SlideOutRight");
        cbTranslate.getItems().add("SlideOutUp");
        cbTranslate.getItems().add("SlideOutDown");
        cbTranslate.setValue(cbTranslate.getItems().get(0));
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
