package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginFormController {
    public TextField txtUsername;
    public PasswordField txtPassword;
    public Button btnLogin;
    public Label lblUsernameHint;
    public Label lblPasswordHint;
    public Label lblStatus;

    public void initialize(){
        /*
            To display a control => setVisible(true)
            To hide a control => setVisible(false)
        */
        lblUsernameHint.setVisible(false);
        lblPasswordHint.setVisible(false);

        lblStatus.setText("-");
    }

    public void btnLoginOnAction(ActionEvent e) {
        String username = txtUsername.getText().strip();
        String password = txtPassword.getText().strip();

        lblUsernameHint.setVisible(true);
        if (username.isBlank()){
            lblUsernameHint.setText("Username can't be empty");
        } else if (containsDigit(username)){
            lblUsernameHint.setText("Username can't contain any digits");
        } else if (!username.equals("admin")) {
            lblUsernameHint.setText("Username does not exist");
        } else{
            lblUsernameHint.setVisible(false);
        }

        lblPasswordHint.setVisible(true);
        if (password.isBlank()){
            lblPasswordHint.setText("Password can't be empty");
        } else if (!isValidPasswordFormat(password)){
            lblPasswordHint.setText("Invalid password format");
        } else if (!password.equals("Dep11")){
            lblPasswordHint.setText("Password mismatch error");
        }else {
            lblPasswordHint.setVisible(false);
        }

        if (username.equals("admin") && password.equals("Dep11")){
            lblStatus.setText("Authenticated");
        }else {
            lblStatus.setText("Access Denied");
        }
    }

    public static boolean isValidPasswordFormat(String password){
        boolean upperCaseLetters = false;
        boolean lowerCaseLetters = false;
        boolean digits = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (upperCaseLetters && lowerCaseLetters && digits) break;
            if (Character.isUpperCase(c)) upperCaseLetters = true;
            if (Character.isLowerCase(c)) lowerCaseLetters = true;
            if (Character.isDigit(c)) digits = true;
        }

        return upperCaseLetters &&  lowerCaseLetters && digits && password.length() >= 4;
    }

    public static boolean containsDigit(String input){
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) return true;
        }
        return false;
    }
}
