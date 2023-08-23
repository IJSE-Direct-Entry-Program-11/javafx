package lk.ijse.dep11;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class ComboBoxSceneController {
    public TextField txtCountry;
    public ComboBox<String> cbCountry;
    public Label lblCountry;
    public Button btnRemoveCountry;
    public Button btnClearCountryList;
    public AnchorPane root;

    public void initialize(){
        cbCountry.setDisable(true);
        btnRemoveCountry.setDisable(true);
        btnClearCountryList.setDisable(true);

        cbCountry.getItems().addListener((Observable o)-> {
            cbCountry.setDisable(cbCountry.getItems().isEmpty());
            btnClearCountryList.setDisable(cbCountry.isDisable());
        });

        cbCountry.getSelectionModel().selectedItemProperty().addListener(e -> {
            String selectedCountry = cbCountry.getSelectionModel().getSelectedItem();
            btnRemoveCountry.setDisable(selectedCountry == null);
            lblCountry.setText(selectedCountry == null ? "-": selectedCountry);

//            if (selectedCountry == null){
//                btnRemoveCountry.setDisable(true);
//                lblCountry.setText("-");
//            }else{
//                btnRemoveCountry.setDisable(false);
//                lblCountry.setText(selectedCountry);
//            }
        });
    }

    public void btnClearCountryListOnAction(ActionEvent actionEvent) {
        cbCountry.getItems().clear();
        txtCountry.requestFocus();
    }

    public void cbCountryOnAction(ActionEvent actionEvent) {
    }

    public void txtCountryOnAction(ActionEvent actionEvent) {
        String country = txtCountry.getText().strip();
        if (country.isEmpty()) return;

        ObservableList<String> countryList = cbCountry.getItems();
        if (countryList.contains(country)){
            new Alert(Alert.AlertType.ERROR, country + " already exists").show();
            return;
        }
        countryList.add(country);
        txtCountry.clear();
    }

    public void btnRemoveCountryOnAction(ActionEvent actionEvent) {
        String selectedCountry = cbCountry.getSelectionModel().getSelectedItem();
        cbCountry.getItems().remove(selectedCountry);
        cbCountry.getSelectionModel().clearSelection();
    }

    public void cbCountryOnKeyPressed(KeyEvent e) {
        if (e.getCode() == KeyCode.DELETE) btnRemoveCountry.fire();
    }

    public void rootOnKeyPressed(KeyEvent e) {
        if (e.getCode() == KeyCode.F12) btnClearCountryList.fire();
    }
}
