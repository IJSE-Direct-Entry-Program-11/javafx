package lk.ijse.dep11;

import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MainSceneController {
    public Slider slrRed;
    public TextField txtRed;
    public Slider slrGreen;
    public Slider slrBlue;
    public TextField txtBlue;
    public Slider slrAlpha;
    public TextField txtAlpha;
    public Rectangle shpPreview;
    public TextField txtColor;
    public TextField txtGreen;

    public void initialize() {
        txtRed.setTooltip(new Tooltip("RED Value"));
        txtGreen.setTooltip(new Tooltip("GREEN Value"));
        txtBlue.setTooltip(new Tooltip("BLUE Value"));
        txtAlpha.setTooltip(new Tooltip("ALPHA Value"));
        txtColor.setTooltip(new Tooltip("COLOR code"));

        slrRed.valueProperty().addListener(e -> {
            txtRed.setText(String.format("%.0f", slrRed.getValue()));
            updateColor();
        });
        slrGreen.valueProperty().addListener(e -> {
            txtGreen.setText(String.format("%.0f", slrGreen.getValue()));
            updateColor();
        });
        slrBlue.valueProperty().addListener(e -> {
            txtBlue.setText(String.format("%.0f", slrBlue.getValue()));
            updateColor();
        });
        slrAlpha.valueProperty().addListener(e -> {
            txtAlpha.setText(String.format("%.0f", slrAlpha.getValue()));
            updateColor();
        });
    }

    void updateColor() {
        int red = Integer.parseInt(txtRed.getText());
        int green = Integer.parseInt(txtGreen.getText());
        int blue = Integer.parseInt(txtBlue.getText());
        int alpha = Integer.parseInt(txtAlpha.getText());
        Color colorRef = Color.rgb(red, green, blue, alpha / 255.0);
        shpPreview.setFill(colorRef);
        txtColor.setText("#" + colorRef.toString().substring(2).toUpperCase());
    }
}
