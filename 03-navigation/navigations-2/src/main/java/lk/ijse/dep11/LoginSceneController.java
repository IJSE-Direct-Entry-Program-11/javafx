package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginSceneController {
    public AnchorPane root;
    public TextField txtUsername;
    public PasswordField txtPassword;
    public Button btnLogin;

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        String[][] users = {
                {"admin", "admin123", "Prasad Waduge", "Yellow"},
                {"kasun", "kasun123", "Sachin Kasun Thamalsha", "YellowGreen"},
                {"nuwan", "nuwan123", "Yasendra Nuwan", "LightBlue"}
        };

        String username = txtUsername.getText().strip();
        String password = txtPassword.getText().strip();

        for (String[] user : users) {
            if (user[0].equals(username) && user[1].equals(password)){
//                AnchorPane mainSceneRoot = FXMLLoader
//                        .load(getClass().getResource("/view/MainScene.fxml"));

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/MainScene.fxml"));
                AnchorPane mainSceneRoot = fxmlLoader.load();

                MainSceneController mainSceneController = fxmlLoader.getController();
                mainSceneController.initData(user[2], user[3]);

                Scene mainScene = new Scene(mainSceneRoot);
                Stage stage = new Stage();
                stage.setScene(mainScene);
                stage.setTitle("Navigation: Main");
                stage.show();

                Stage loginStage = (Stage) root.getScene().getWindow();
                loginStage.close();
                return;
            }
        }

        new Alert(Alert.AlertType.ERROR, "Invalid username and password combination").show();
        txtUsername.requestFocus();
    }
}
