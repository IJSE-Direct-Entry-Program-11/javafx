package lk.ijse.dep11;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class MainSceneController {
    public Button btnStart;
    public ProgressBar pb1;
    public Label lblProgress;
    public ProgressBar pb2;

    public void btnStartOnAction(ActionEvent actionEvent) throws InterruptedException {
        // pb1.getProgress(): double
        // pb1.setProgress(double progress): void
        // progress value = {0 - 1}
        // progress value = -1

        Task<Void> myLongRunningTask = new Task<>(){
            @Override
            protected Void call() throws Exception {
                // Your code goes here
                System.out.println(Thread.currentThread().getName());
                Platform.runLater(()-> {
                    System.out.println(Thread.currentThread().getName());
                    pb1.setProgress(0);
                });

                for (int i = 0; i < 50; i++) {
                    System.out.println("Direct Entry Program - " + i);
                    int k = i;

                    Platform.runLater(()->{
                        lblProgress.setText("Value: " + String.format("%.0f", (k / 50.0 * 100)).concat("%"));
                        pb1.setProgress(k / 50.0);
                    });

                    Thread.sleep(100);
                }

                Platform.runLater(()->{
                    lblProgress.setText("Value: 100%");
                    pb1.setProgress(1);
                });
                return null;
            }
        };

        new Thread(myLongRunningTask).start();

    }

    public void btnPlatformExitOnAction(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void btnSystemExitOnAction(ActionEvent actionEvent) {
        System.exit(0);
    }
}
