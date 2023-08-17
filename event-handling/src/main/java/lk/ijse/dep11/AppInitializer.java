package lk.ijse.dep11;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        /* Let's start the Java FX Runtime Environment */
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        /* Let's create the scene */
        AnchorPane root = FXMLLoader.load(getClass().getResource("/view/MainScene.fxml"));
        Scene mainScene = new Scene(root);

        /* Let's set the scene */
        primaryStage.setScene(mainScene);

        /* Let's decorate the stage */
        primaryStage.centerOnScreen();
        primaryStage.setTitle("Java FX Event Handling");

        /* Let's open the stage */
        primaryStage.show();
    }
}
