package lk.ijse.dep11;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        launch(args);
        System.out.println(Thread.currentThread().getName());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/view/AboutScene.fxml"));
        Scene mainScene = new Scene(root);

        primaryStage.setScene(mainScene);

        primaryStage.setTitle("Hello Java FX 5");

        primaryStage.centerOnScreen();
        primaryStage.show();
//        primaryStage.setResizable(false);
//        primaryStage.setAlwaysOnTop(true);
    }
}
