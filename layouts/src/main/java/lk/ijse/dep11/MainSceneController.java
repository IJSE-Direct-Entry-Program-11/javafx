package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Stack;

public class MainSceneController {
    public AnchorPane root;
    public Button btnAnchorPaneLayout;
    public Button btnBorderPaneLayout;
    public Button btnFlowPaneLayout;

    public void btnAnchorPaneLayoutOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPaneLayoutSceneRoot = FXMLLoader.load(getClass().getResource("/view/AnchorPaneLayoutScene.fxml"));
        Scene scene = new Scene(anchorPaneLayoutSceneRoot);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Anchor Pane Layout");
        stage.show();
    }

    public void btnBorderPaneLayoutOnAction(ActionEvent actionEvent) throws IOException {
        BorderPane borderPaneLayoutSceneRoot = FXMLLoader.load(getClass().getResource("/view/BorderPaneLayoutScene.fxml"));
        Scene scene = new Scene(borderPaneLayoutSceneRoot);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Border Pane Layout");
        stage.show();
    }

    public void btnFlowPaneLayoutOnAction(ActionEvent actionEvent) throws IOException {
        FlowPane flowPaneLayoutSceneRoot = FXMLLoader.load(getClass().getResource("/view/FlowPaneLayoutScene.fxml"));
        Scene scene = new Scene(flowPaneLayoutSceneRoot);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Flow Pane Layout");
        stage.show();
    }
}
