package lk.ijse.dep11;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class MainSceneController {

    public AnchorPane root;
    public Button btnValidate;
    public TextField txtNIC;
    public ImageView imvCrazy;

    public void initialize(){
        btnValidate.setOnMouseClicked(e -> {
            System.out.println("Click Kala...!");
        });

        txtNIC.setOnKeyPressed(e -> {
            System.out.println("Ebuwa");
        });

        txtNIC.setOnKeyReleased(e -> {
            System.out.println("Issuwa");
        });

        root.setCursor(Cursor.NONE);
        root.setOnMouseMoved(e -> {
            imvCrazy.setLayoutX(e.getX() - imvCrazy.getFitWidth() / 2);
            imvCrazy.setLayoutY(e.getY() - imvCrazy.getFitHeight() / 2);
            System.out.printf("x=%.2f, y=%.2f \n", e.getX(), e.getY());
        });
    }
}
