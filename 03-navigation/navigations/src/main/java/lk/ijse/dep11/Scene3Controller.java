package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Scene3Controller {
    public Button btnGoToScene1;
    public Button btnGoToScene2;
    public AnchorPane root;

    public void btnGoToScene1OnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane scene1Root = FXMLLoader.load(getClass().getResource("/view/Scene1.fxml"));
        Scene scene1 = new Scene(scene1Root);

        Stage primaryStage = (Stage) root.getScene().getWindow();
        primaryStage.setScene(scene1);
        primaryStage.sizeToScene();
    }

    public void btnGoToScene2OnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane scene2Root = FXMLLoader.load(getClass().getResource("/view/Scene2.fxml"));
        Scene scene2 = new Scene(scene2Root);

        Stage primaryStage = (Stage) root.getScene().getWindow();
        primaryStage.setScene(scene2);
        primaryStage.sizeToScene();
    }
}
