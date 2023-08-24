package lk.ijse.dep11;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.dep11.tm.Customer;

public class MainSceneController {
    public TableView<Customer> tblCustomers;
    public Button btnNewCustomer;
    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public Button btnSave;
    public Button btnDelete;

    public void initialize() {
        /* Columns Mapping */
        tblCustomers.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblCustomers.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblCustomers.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));

        btnDelete.setDisable(true);

        tblCustomers.getSelectionModel().selectedItemProperty().addListener((value, previous, current)->{
            btnDelete.setDisable(current == null);
            if (current != null){
                txtId.setText(current.getId() + "");
                txtName.setText(current.getName());
                txtAddress.setText(current.getAddress());
            }
        });
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        Customer selectedCustomer = tblCustomers.getSelectionModel().getSelectedItem();
        ObservableList<Customer> customerList = tblCustomers.getItems();
        customerList.remove(selectedCustomer);
        if (customerList.isEmpty()) btnNewCustomer.fire();
    }

    public void btnNewCustomerOnAction(ActionEvent actionEvent) {
        txtId.clear();
        txtName.clear();
        txtAddress.clear();
        txtId.requestFocus();
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        if (txtId.getText().isBlank() || !isValidId(txtId.getText().strip())){
            txtId.requestFocus();
            txtId.selectAll();
            return;
        }else if (txtName.getText().isBlank()){
            txtName.requestFocus();
            txtName.selectAll();
            return;
        }else if (txtAddress.getText().isBlank()){
            txtAddress.requestFocus();
            txtAddress.selectAll();
            return;
        }
        int id = Integer.parseInt(txtId.getText());
        String name = txtName.getText();
        String address = txtAddress.getText();
        Customer newCustomer = new Customer(id, name, address);
        ObservableList<Customer> customerList = tblCustomers.getItems();

        for (Customer customer : customerList) {
            if (customer.getId() == id){
                new Alert(Alert.AlertType.ERROR, "ID: " + id + " already exists").show();
                txtId.requestFocus();
                txtId.selectAll();
                return;
            }
        }

        customerList.add(newCustomer);
        btnNewCustomer.fire();
    }

    boolean isValidId(String input){
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) return false;
        }
        return true;
    }
}
