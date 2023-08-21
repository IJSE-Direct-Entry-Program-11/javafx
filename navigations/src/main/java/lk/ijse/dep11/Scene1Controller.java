package lk.ijse.dep11;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Scene1Controller {
    public Button btnGoToScene2;
    public Button btnGoToScene3;
    public AnchorPane root;

    public void btnGoToScene2OnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane scene2Root = FXMLLoader.load(getClass().getResource("/view/Scene2.fxml"));
        Scene scene2 = new Scene(scene2Root);

        Stage primaryStage = (Stage) root.getScene().getWindow();
        primaryStage.setScene(scene2);
        primaryStage.sizeToScene();
        primaryStage.centerOnScreen();

        TranslateTransition translate = new TranslateTransition(Duration.millis(200), scene2Root);
        translate.setFromX(-100);
        translate.setToX(0);
        translate.playFromStart();
    }

    public void btnGoToScene3OnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane scene3Root = FXMLLoader.load(getClass().getResource("/view/Scene3.fxml"));
        Scene scene3 = new Scene(scene3Root);

        Stage primaryStage = (Stage) root.getScene().getWindow();
        primaryStage.setScene(scene3);
        primaryStage.sizeToScene();
        primaryStage.centerOnScreen();
    }
}
