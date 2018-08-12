package sample.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


public class Controller {
    @FXML
    private JFXTextField usernameField,
            passwordField;

    @FXML
    private JFXButton loginButton,
                      cancelButton;

    @FXML
    public void initialize() {
        loginButton.setDisable(true);
        usernameField.textProperty().addListener(this.onInputChange());
    }

    private ChangeListener<String> onInputChange() {
        return new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                boolean disable = newValue.trim().isEmpty();
                loginButton.setDisable(disable);
            }
        };
    }

    /**
     * Login page button click handler
     */
    @FXML
    public void onButtonClicked(ActionEvent e) {

        // check the clicked button
        if (e.getSource().equals(loginButton)) {
            this.loginUser();
        } else if (e.getSource().equals(cancelButton)) {
            this.cancelLogin();
        }
    }

    /**
     * Login handler
     */
    private void loginUser() {
        String token = ""; // Get/Generate token
        try {
            if (this.validateFromApi(
                    usernameField.getText().trim(),
                    passwordField.getText().trim(), token)) {
                System.out.println("Validated!");
            }
        }catch (Error e) {
            System.out.println(e.toString());
        }
    }

    /**
     * Cancel handler
     */
    private void cancelLogin() {

    }

    /**
     * Validates user from WebAPI
     * @param username string from input
     * @param password string from input
     * @param token string from input
     * @return returns generated user object (true dummy)
     */
    private boolean validateFromApi(String username, String password, String token) {
        return true;
    }
}