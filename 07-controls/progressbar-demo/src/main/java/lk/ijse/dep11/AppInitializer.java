package lk.ijse.dep11;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        System.out.println("About to start the Java FX Runtime Environment");
        launch(args);
        System.out.println("Just exit from the Java FX Runtime Environment");
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        System.out.println(Thread.currentThread().getName());
        AnchorPane root = FXMLLoader.load(getClass().getResource("/view/MainScene.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Progress Bar Demo");
        primaryStage.show();
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();

        primaryStage.setOnCloseRequest(e -> {
            Optional<ButtonType> buttonRef = new Alert(Alert.AlertType.CONFIRMATION,
                    "Are you sure to exit?",
                    ButtonType.YES, ButtonType.NO).showAndWait();

            if (buttonRef.get() == ButtonType.NO){
                e.consume();
            }
        });
    }
}
