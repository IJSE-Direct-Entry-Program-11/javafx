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
        /* Let's create the scene first */
        AnchorPane root = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));
        Scene mainScene = new Scene(root);

        primaryStage.setScene(mainScene);

        primaryStage.setTitle("Event Handling");
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();

        primaryStage.show();
    }
}
