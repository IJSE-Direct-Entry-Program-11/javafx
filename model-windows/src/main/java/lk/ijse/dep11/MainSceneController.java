package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainSceneController {
    public Button btnNewStage;
    public Button btnWindowModal;
    public AnchorPane root;
    public Button btnApplicationModal;

    public void btnNewStageOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane mainSceneRoot = FXMLLoader.load(getClass().getResource("/view/MainScene.fxml"));
        Scene mainScene = new Scene(mainSceneRoot);

        Stage stage = new Stage();
        stage.setScene(mainScene);
        stage.setTitle("New Stage");
        stage.show();
    }

    public void btnWindowModalOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane scene1Root = FXMLLoader.load(getClass().getResource("/view/Scene1.fxml"));
        Scene scene1 = new Scene(scene1Root);

        Stage stage = new Stage();

        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(root.getScene().getWindow());

        stage.setScene(scene1);
        stage.setTitle("New Modal Window");
        stage.show();
    }

    public void btnApplicationModalOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane scene1Root = FXMLLoader.load(getClass().getResource("/view/Scene1.fxml"));
        Scene scene1 = new Scene(scene1Root);

        Stage stage = new Stage();

        stage.initModality(Modality.APPLICATION_MODAL);

        stage.setScene(scene1);
        stage.setTitle("New Modal Window");
        stage.show();
    }
}
