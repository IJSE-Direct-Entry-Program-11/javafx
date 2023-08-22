package lk.ijse.dep11;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        /* Let's load the scene design */
        AnchorPane root = FXMLLoader.load(getClass().getResource("/view/LoginForm.fxml"));
        /* Let's create the scene from the design */
        Scene mainScene = new Scene(root);
        /* Let's place the scene in the stage */
        primaryStage.setScene(mainScene);
        /* Let's decorate the stage as we wish*/
        primaryStage.setResizable(false);
        primaryStage.setTitle("Login App");
        primaryStage.centerOnScreen();
        /* Let's open the stage */
        primaryStage.show();
    }
}
