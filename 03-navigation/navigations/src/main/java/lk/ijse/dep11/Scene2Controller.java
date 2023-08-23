package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Scene2Controller {
    public Button btnGoToScene1;
    public Button btnGoToScene3;
    public AnchorPane root;

    public void btnGoToScene1OnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane scene1Root = FXMLLoader.load(getClass().getResource("/view/Scene1.fxml"));
        Scene scene1 = new Scene(scene1Root);

        Stage primaryStage = (Stage) root.getScene().getWindow();
        primaryStage.setScene(scene1);
        primaryStage.sizeToScene();
    }

    public void btnGoToScene3OnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane scene3Root = FXMLLoader.load(getClass().getResource("/view/Scene3.fxml"));
        Scene scene3 = new Scene(scene3Root);

        Stage primaryStage = (Stage) root.getScene().getWindow();
        primaryStage.setScene(scene3);
        primaryStage.sizeToScene();
    }
}
