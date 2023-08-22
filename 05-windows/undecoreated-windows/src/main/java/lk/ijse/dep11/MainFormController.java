package lk.ijse.dep11;

import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Point2D;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;

public class MainFormController {
    public AnchorPane root;
    public Point2D point;

    public void onMouseMove(MouseEvent e) {
        Stage primaryStage = (Stage) root.getScene().getWindow();
        primaryStage.setX(e.getScreenX() - point.getX());
        primaryStage.setY(e.getScreenY() - point.getY());
    }

    public void onMouseClicked(MouseEvent e) {
        point = new Point2D(e.getX(), e.getY());
    }
}
