package lk.ijse.dep11;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.*;
import javafx.scene.shape.Rectangle;

public class MainSceneController {
    public Label lblDragMe;
    public Rectangle shpTarget;

    private double xPos = 0;
    private double yPos = 0;
    private double initialXPos;
    private double initialYPos;

    public void lblDragMeOnMouseDragged(MouseEvent e) {
//        System.out.printf("x=%.2f, sceneX=%.2f, screenX=%.2f \n", e.getX(), e.getSceneX(), e.getScreenX());
//        System.out.println(e.getSceneX() - xPos);
        lblDragMe.setLayoutX(e.getSceneX() - xPos);
        lblDragMe.setLayoutY(e.getSceneY() - yPos);
    }

    public void lblDragMeOnMousePressed(MouseEvent e) {
        xPos = e.getX();
        yPos = e.getY();
        initialXPos = lblDragMe.getLayoutX();
        initialYPos = lblDragMe.getLayoutY();
    }

    public void lblDragMeOnMouseReleased(MouseEvent e) {
        double x = lblDragMe.getLayoutX();
        double y = lblDragMe.getLayoutY();
        if (x >= shpTarget.getLayoutX() &&
            x <= (shpTarget.getLayoutX() + shpTarget.getWidth() - lblDragMe.getWidth()) &&
            y >= shpTarget.getLayoutY() &&
            y <= (shpTarget.getLayoutY() + shpTarget.getHeight() - lblDragMe.getHeight())){
            System.out.println("Dropped");
        }else{
            lblDragMe.setLayoutX(initialXPos);
            lblDragMe.setLayoutY(initialYPos);
        }
    }
}
