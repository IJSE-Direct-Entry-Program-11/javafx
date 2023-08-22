package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class MainSceneController {
    public Button btnLogOut;
    public Label lblGreeting;
    public AnchorPane root;

    public void initData(String userFullName, String backgroundColor){
        lblGreeting.setText(String.format("Welcome %s!", userFullName));
        root.setBackground(Background.fill(Color.web(backgroundColor)));
    }

    public void btnLogOutOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane loginSceneRoot = FXMLLoader.load(getClass().getResource("/view/LoginScene.fxml"));
        Scene loginScene = new Scene(loginSceneRoot);

        Stage stage = new Stage();
        stage.setScene(loginScene);
        stage.setTitle("Navigation: Login");
        stage.setResizable(false);
        stage.show();

        Stage mainStage = (Stage) root.getScene().getWindow();
        mainStage.close();
    }
}
