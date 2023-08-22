package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public class MainSceneController {
    public AnchorPane root;
    public Button btnAnchorPaneLayout;
    public Button btnBorderPaneLayout;
    public Button btnFlowPaneLayout;
    public Button btnTilePaneLayout;
    public Button btnGridPaneLayout;
    public Button btnStackPaneLayout;
    public Button btnMiscLayout;

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

    public void btnTilePaneLayoutOnAction(ActionEvent actionEvent) throws IOException {
        TilePane tilePaneLayoutSceneRoot = FXMLLoader.load(getClass().getResource("/view/TilePaneLayoutScene.fxml"));
        Scene scene = new Scene(tilePaneLayoutSceneRoot);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Tile Pane Layout");
        stage.show();
    }

    public void btnGridPaneLayoutOnAction(ActionEvent actionEvent) throws IOException {
        GridPane gridPaneLayoutSceneRoot = FXMLLoader.load(getClass().getResource("/view/GridPaneLayoutScene.fxml"));
        Scene scene = new Scene(gridPaneLayoutSceneRoot);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Grid Pane Layout");
        stage.show();
    }

    public void btnStackPaneLayoutOnAction(ActionEvent actionEvent) throws IOException {
        StackPane stackPaneLayoutSceneRoot = FXMLLoader.load(getClass().getResource("/view/StackPaneLayoutScene.fxml"));
        Scene scene = new Scene(stackPaneLayoutSceneRoot);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Stack Pane Layout");
        stage.show();
    }

    public void btnMiscLayoutOnAction(ActionEvent actionEvent) throws IOException {
        TabPane tabAndAccordionPaneLayoutSceneRoot = FXMLLoader.load(getClass().getResource("/view/TabAndAccordionPaneLayoutScene.fxml"));
        Scene scene = new Scene(tabAndAccordionPaneLayoutSceneRoot);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Tab / Accordion Pane Layout");
        stage.show();
    }
}
