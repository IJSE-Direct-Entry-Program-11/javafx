package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MainSceneController {
    public ToggleButton tglVisibility;
    public ToggleButton tglDisability;
    public Button btnFocus;
    public TextField txtSomething;
    public ToggleButton tglToolTip;
    public RadioButton rdoDefaultCursor;
    public RadioButton rdoHandCursor;
    public AnchorPane root;
    public Label lblOutput;
    public CheckBox chkBackgroundColor;
    public ColorPicker clrBackground;
    public CheckBox chkBorder;
    public Spinner<Integer> txtBorderWidth;
    public ColorPicker clrBorderColor;
    public Rectangle shpRect;
    public Label lblTitle;
    public Slider slrOpacity;
    public Label lblOpacityValue;

    public void initialize() {
        txtBorderWidth.setValueFactory(new SpinnerValueFactory
                .IntegerSpinnerValueFactory(0, 10, 1));

        Color colorRef = clrBackground.getValue();
        lblTitle.setBackground(Background.fill(colorRef));
        lblTitle.setTextFill(Color.WHITE);

        chkBackgroundColor.setSelected(true);
        chkBorder.setSelected(true);
        rdoDefaultCursor.setSelected(true);
        tglVisibility.setSelected(true);
        tglToolTip.fire();
        txtSomething.focusedProperty().addListener(e -> {
            System.out.println(txtSomething.isFocused() ? "Focus Gained" : "Focus Lost");
        });

        txtSomething.textProperty().addListener(e -> {
            lblOutput.setText(String.format("Output: %s", txtSomething.getText()));
        });

        txtBorderWidth.valueProperty().addListener(e -> {
            System.out.println(txtBorderWidth.getValue());
            changeBorder();
        });

        slrOpacity.valueProperty().addListener(e -> {
            System.out.println(slrOpacity.getValue());
            lblTitle.setOpacity(slrOpacity.getValue() / 100);
            shpRect.setOpacity(slrOpacity.getValue() / 100);
            lblOpacityValue.setText(String.format("Value: %.2f", slrOpacity.getValue()).concat("%"));
        });
    }

    public void tglVisibilityOnAction(ActionEvent actionEvent) {
        System.out.println(tglVisibility.isSelected());
        txtSomething.setVisible(tglVisibility.isSelected());
        System.out.println("Is txtSomething visible? " + txtSomething.isVisible());
    }

    public void tglDisabilityOnAction(ActionEvent actionEvent) {
        System.out.println(tglDisability.isSelected());
        txtSomething.setDisable(tglDisability.isSelected());
        System.out.println("Is txtSomething disabled? " + txtSomething.isDisable());
    }

    public void btnFocusOnAction(ActionEvent actionEvent) {
        System.out.println("Has txtSomething gained the focus? " + txtSomething.isFocused());
        txtSomething.requestFocus();
        System.out.println("Has txtSomething gained the focus? " + txtSomething.isFocused());
    }

    public void tglToolTipOnAction(ActionEvent actionEvent) {
        if (tglToolTip.isSelected()) {
            rdoDefaultCursor.setTooltip(new Tooltip("Click to fall back to the default cursor"));
            rdoHandCursor.setTooltip(new Tooltip("Click to change the cursor to hand"));
        } else {
            rdoHandCursor.setTooltip(null);
            rdoDefaultCursor.setTooltip(null);
        }
        System.out.println("What is the tooltip of rdoDefaultCursor: " + rdoDefaultCursor.getTooltip());
        if (rdoDefaultCursor.getTooltip() != null) {
            System.out.println("What is the tooltip text of the rdoDefaultCursor: " +
                    rdoDefaultCursor.getTooltip().getText());
        }
    }

    public void rdoDefaultCursorOnAction(ActionEvent actionEvent) {
        root.setCursor(Cursor.DEFAULT);
    }

    public void rdoHandCursorOnAction(ActionEvent actionEvent) {
        System.out.println("What is the cursor of the root elm? " + root.getCursor());
        root.setCursor(Cursor.HAND);
        System.out.println("What is the cursor of the root elm now? " + root.getCursor());
    }

    public void chkBorderOnAction(ActionEvent actionEvent) {
        clrBorderColor.setDisable(!chkBorder.isSelected());
        txtBorderWidth.setDisable(!chkBorder.isSelected());
    }

    public void chkBackgroundColorOnAction(ActionEvent actionEvent) {
        clrBackground.setDisable(!chkBackgroundColor.isSelected());
//        if (chkBackgroundColor.isSelected()){
//            clrBackground.setDisable(false);
//        }else{
//            clrBackground.setDisable(true);
//        }
    }

    public void clrBackgroundOnAction(ActionEvent actionEvent) {
        Color selectedBackgroundColor = clrBackground.getValue();
        shpRect.setFill(selectedBackgroundColor);
        lblTitle.setBackground(Background.fill(selectedBackgroundColor));
    }

    void changeBorder() {
        shpRect.setStroke(clrBorderColor.getValue());
        shpRect.setStrokeWidth(txtBorderWidth.getValue());
//        shpRect.getStrokeDashArray().clear();
//        shpRect.getStrokeDashArray().addAll(2.0, 4.0);

//        Color colorRef = clrBorderColor.getValue();
//        BorderStrokeStyle styleRef = BorderStrokeStyle.SOLID;
//        CornerRadii cornerRadiusRef = null; //new CornerRadii(50);
//        BorderWidths borderWidthsRef = new BorderWidths(txtBorderWidth.getValue());
//
//        BorderStroke borderStrokeRef =  new BorderStroke(colorRef, styleRef, cornerRadiusRef, borderWidthsRef);
//        Border borderRef = new Border(borderStrokeRef);
//        lblTitle.setBorder(borderRef);

        String borderStyle = String.format("-fx-border-width: %dpx;-fx-border-color: #%s;",
                txtBorderWidth.getValue(),
                clrBorderColor.getValue().toString().substring(2));
        lblTitle.setStyle(borderStyle);
    }

    public void clrBorderColorOnAction(ActionEvent actionEvent) {
        changeBorder();
    }
}
