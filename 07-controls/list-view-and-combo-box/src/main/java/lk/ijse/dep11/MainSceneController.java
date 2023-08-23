package lk.ijse.dep11;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;

public class MainSceneController {
    public TextField txtSubject;
    public ListView<String> lvSubjects;
    public ListView<String> lvSelectedSubjects;
    public Button btnNext;
    public Button btnBack;
    public Button btnRemove;
    public Button btnClear;

    public void initialize() {
        btnNext.setTooltip(new Tooltip("Click to select the subject"));
        btnBack.setTooltip(new Tooltip("Click to remove the selected subject"));
        Font fontRef = Font.font(12);
        btnNext.getTooltip().setFont(fontRef);
        btnBack.getTooltip().setFont(fontRef);

        btnClear.setDisable(true);
        btnRemove.setDisable(true);
        btnBack.setDisable(true);
        btnNext.setDisable(true);

//        for (Button btn : new Button[]{btnClear, btnRemove, btnBack, btnNext}) btn.setDisable(true);

        ObservableList<String> subjectList = lvSubjects.getItems();
        subjectList.addListener((Observable o) -> {
            btnClear.setDisable(subjectList.isEmpty());
        });

        lvSubjects.getSelectionModel().selectedItemProperty().addListener(e -> {
            btnRemove.setDisable(lvSubjects.getSelectionModel().getSelectedItem() == null);
            btnNext.setDisable(btnRemove.isDisable());

//            if (lvSubjects.getSelectionModel().getSelectedItem() == null){
//                btnRemove.setDisable(true);
//            }else{
//                btnRemove.setDisable(false);
//            }
        });

        lvSelectedSubjects.getSelectionModel().selectedItemProperty().addListener(e -> {
            btnBack.setDisable(lvSelectedSubjects.getSelectionModel().getSelectedItem() == null);
//            if (lvSelectedSubjects.getSelectionModel().getSelectedItem() == null){
//                btnBack.setDisable(true);
//            }else{
//                btnBack.setDisable(false);
//            }
        });
    }

    public void txtSubjectOnAction(ActionEvent actionEvent) {
        String subject = txtSubject.getText().strip();
        if (subject.isBlank()) return;

        ObservableList<String> subjectList = lvSubjects.getItems();
        if (subjectList.contains(subject)) {
            new Alert(Alert.AlertType.ERROR, subject + " already exists, try something different").show();
            txtSubject.selectAll();
            return;
        }

        subjectList.add(subject);
        txtSubject.clear();
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        ObservableList<String> subjectList = lvSubjects.getItems();
        subjectList.clear();
    }

    public void btnNextOnAction(ActionEvent actionEvent) {
        ObservableList<String> subjectList = lvSubjects.getItems();
        ObservableList<String> selectedSubjectList = lvSelectedSubjects.getItems();

        String selectedItem = lvSubjects.getSelectionModel().getSelectedItem();
        subjectList.remove(selectedItem);
        selectedSubjectList.add(selectedItem);
    }

    public void btnBackOnAction(ActionEvent actionEvent) {
        ObservableList<String> subjectList = lvSubjects.getItems();
        ObservableList<String> selectedSubjectList = lvSelectedSubjects.getItems();

        String selectedItem = lvSelectedSubjects.getSelectionModel().getSelectedItem();
        subjectList.add(selectedItem);
        selectedSubjectList.remove(selectedItem);
    }

    public void btnRemoveOnAction(ActionEvent actionEvent) {
        lvSubjects.getItems().remove(lvSubjects.getSelectionModel().getSelectedItem());
//        ObservableList<String> subjectList = lvSubjects.getItems();
//        String selectedItem = lvSubjects.getSelectionModel().getSelectedItem();
//        subjectList.remove(selectedItem);
        lvSubjects.getSelectionModel().clearSelection();
    }

    public void lvSubjectsOnKeyPressed(KeyEvent e) {
        if (e.getCode() == KeyCode.ENTER) btnNext.fire();
        else if (e.getCode() == KeyCode.DELETE) btnRemove.fire();
    }

    public void lvSelectedSubjectsOnKeyPressed(KeyEvent e){
        if (e.getCode() == KeyCode.BACK_SPACE) btnBack.fire();
    }
}
