package lk.ijse.dep11;

import javafx.animation.FadeTransition;
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
    public Button btnOpenInNewStage;

    public void btnOpenInNewStageOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane scene1Root = FXMLLoader.load(getClass().getResource("/view/Scene1.fxml"));
        Scene scene1 = new Scene(scene1Root);

        Stage stage = new Stage();
        stage.setScene(scene1);
        stage.setTitle("This is a new stage");
        stage.show();
    }

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

        FadeTransition fade = new FadeTransition(Duration.millis(200), scene3Root);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.playFromStart();
    }
}
