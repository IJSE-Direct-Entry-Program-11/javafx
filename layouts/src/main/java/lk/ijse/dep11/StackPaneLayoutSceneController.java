package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class StackPaneLayoutSceneController {
    public Circle shpCircle;
    public Button btnBringToFront;
    public Rectangle shpRectangle;
    public Polygon shpPoly;

    boolean front = false;

    public void initialize(){
        shpRectangle.setViewOrder(1);
        shpPoly.setViewOrder(1);
        shpCircle.setViewOrder(2);
    }

    public void btnBringToFrontOnAction(ActionEvent actionEvent) {
//        shpCircle.toFront();
//        shpCircle.toBack();
        shpCircle.setViewOrder((front = !front) ? 0 : 2);
    }
}
