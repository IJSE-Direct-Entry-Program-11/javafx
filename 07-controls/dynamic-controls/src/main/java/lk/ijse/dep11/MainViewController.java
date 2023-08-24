package lk.ijse.dep11;

import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class MainViewController {
    public Spinner<Integer> txtCount;
    public AnchorPane root;

    public void initialize(){
        txtCount.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 5, 2, 1));

        Button btnGenerateSubject = new Button("Generate Subjects");
        root.getChildren().add(btnGenerateSubject);
        btnGenerateSubject.setLayoutX(250);
        btnGenerateSubject.setLayoutY(35);

        VBox vBox = new VBox();
        vBox.setLayoutY(80);
        vBox.setLayoutX(10);
        vBox.setSpacing(10);
        root.getChildren().add(vBox);

        btnGenerateSubject.setOnAction(e -> {
            vBox.getChildren().clear();
            for (int i = 0; i < txtCount.getValue(); i++) {
                TextField textField = new TextField();
                vBox.getChildren().add(textField);
            }
        });

    }
}
