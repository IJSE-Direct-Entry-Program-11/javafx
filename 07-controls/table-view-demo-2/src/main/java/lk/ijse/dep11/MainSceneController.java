package lk.ijse.dep11;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.dep11.tm.Student;

public class MainSceneController {

    public Button btnNewStudent;
    public TextField txtId;
    public TextField txtName;
    public ComboBox<String> cbProgramme;
    public TextField txtContact;
    public Button btnSave;
    public Button btnDelete;
    public TableView<Student> tblStudents;

    public void initialize(){
        btnDelete.setDisable(true);

        cbProgramme.getItems().addAll("Direct Entry Program",
                "Graduate Diploma in Software Engineering",
                "Comprehensive Master Java Developer",
                "Advanced Business Solution Developer");

        /* Column Mapping */
        tblStudents.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblStudents.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblStudents.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("programme"));
        tblStudents.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("contact"));

        Platform.runLater(()-> btnNewStudent.fire());

        tblStudents.getSelectionModel().selectedItemProperty().addListener((value, previous, current)-> {
            btnDelete.setDisable(current == null);
            if (current != null){
                txtId.setText(String.format("S-%04d", current.getId()));
                txtName.setText(current.getName());
                cbProgramme.setValue(current.getProgramme());
                txtContact.setText(current.getContact());
            }
        });
    }

    public void btnNewStudentOnAction(ActionEvent actionEvent) {
        txtId.setText(generateNewId());
        txtName.clear();
        txtContact.clear();
        cbProgramme.getSelectionModel().clearSelection();
        txtName.requestFocus();
    }

    String generateNewId(){
        ObservableList<Student> studentList = tblStudents.getItems();
        if (!studentList.isEmpty()){
            int newId = studentList.get(studentList.size() - 1).getId() + 1;
            return String.format("S-%04d", newId);
        }else{
            return "S-0001";
        }
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        if (txtName.getText().isBlank()){
            txtName.requestFocus();
            txtName.selectAll();
            return;
        }else if (cbProgramme.getSelectionModel().isEmpty()){
            cbProgramme.requestFocus();
            return;
        }else if (txtContact.getText().isBlank()){
            txtContact.requestFocus();
            txtContact.selectAll();
            return;
        }

        // S-0001 => 0001
        int id = Integer.parseInt(txtId.getText().substring(2));
        String name = txtName.getText().strip();
        String programme = cbProgramme.getSelectionModel().getSelectedItem();
        String contact = txtContact.getText().strip();
        Student newStudent = new Student(id, name, programme, contact);
        ObservableList<Student> studentList = tblStudents.getItems();

        studentList.add(newStudent);
        btnNewStudent.fire();
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        ObservableList<Student> studentList = tblStudents.getItems();
        Student selectedStudent = tblStudents.getSelectionModel().getSelectedItem();
        studentList.remove(selectedStudent);
        if (studentList.isEmpty()) btnNewStudent.fire();
    }
}