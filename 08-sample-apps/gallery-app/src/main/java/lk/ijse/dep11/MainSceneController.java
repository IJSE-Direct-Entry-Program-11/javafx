package lk.ijse.dep11;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.stage.DirectoryChooser;

import java.io.File;
import java.util.ArrayList;

public class MainSceneController {
    public TextField txtFolderPath;
    public Button btnBrowse;
    public ProgressBar pbLoader;
    public TilePane tlpImageContainer;
    public AnchorPane root;
    public Label lblImageCount;

    public void initialize() {
        //tlpImageContainer.prefWidthProperty().bind(root.widthProperty());
        //tlpImageContainer.prefHeightProperty().bind(root.heightProperty());
    }

    public void btnBrowseOnAction(ActionEvent actionEvent) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Select an image folder");
        File imageDir = directoryChooser.showDialog(root.getScene().getWindow());

        if (imageDir == null) {
            txtFolderPath.clear();
        } else {
            txtFolderPath.setText(imageDir.getAbsolutePath());

            File[] files = imageDir.listFiles();
            ArrayList<File> imageFileList = new ArrayList<>();

            for (File file : files) {
                if (!file.isFile() || !isImageFile(file.getAbsolutePath())) continue;

                imageFileList.add(file);
            }

            tlpImageContainer.getChildren().clear();
            lblImageCount.setVisible(false);
            pbLoader.setVisible(true);
            pbLoader.setProgress(0);

            Task<Void> loadImagesTask = new Task<Void>() {
                int count = 0;

                @Override
                protected Void call() throws Exception {
                    for (File imageFile : imageFileList) {
                        Image image = new Image(imageFile.toURI().toString(), true); // true enables background loading
                        ImageView imageView = new ImageView(image);

                        imageView.setFitWidth(105);
                        imageView.setFitHeight(105);

                        StackPane imageViewContainer = new StackPane(imageView);
                        imageViewContainer.setPrefSize(108,108);
                        imageViewContainer.setAlignment(Pos.CENTER);

                        imageView.setOnMouseEntered(e -> {
                            imageView.setCursor(Cursor.HAND);
                            imageView.setScaleX(1.1);
                            imageView.setScaleY(1.1);
                        });
                        imageView.setOnMouseExited(e -> {
                            imageView.setScaleX(1);
                            imageView.setScaleY(1);
                        });

                        // This runs the code on the JavaFX Application Thread
                        Platform.runLater(() -> {
                            tlpImageContainer.getChildren().add(imageViewContainer);
                            count++;
                            pbLoader.setProgress(count / (double) imageFileList.size());
                        });

                        // Let's just give a small break to the thread so the JavaFX Application thread can render the progress
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    return null;
                }
            };

            loadImagesTask.setOnSucceeded(e -> {
                pbLoader.setVisible(false);
                lblImageCount.setVisible(true);
                lblImageCount.setText(String.format("Total Image Count: %s", imageFileList.size()));
            });
            new Thread(loadImagesTask).start();
        }
    }

    public boolean isImageFile(String filePath) {
        String[] imageFileExtensions = {".jpg", ".jpeg", ".gif", ".png", ".bmp"};
        for (String ext : imageFileExtensions) {
            if (filePath.endsWith(ext)) return true;
        }
        return false;
    }
}
