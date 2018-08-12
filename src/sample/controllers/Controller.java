package sample.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import sample.Main;


public class Controller {
    @FXML
    private JFXTextField usernameField,
            passwordField;
    @FXML
    private JFXButton loginButton,
                      cancelButton;
    @FXML
    private JFXToggleButton rememberMeToggle;

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
            if(this.loginUser()) {
                // user validated, redirect to other scene
            }
        } else if (e.getSource().equals(cancelButton)) {
            this.cancelLogin();
        }
    }

    /**
     * Login handler
     */
    private boolean loginUser() {
        String token = ""; // Get/Generate token
        try {
            if (this.validateFromApi(
                    usernameField.getText().trim(),
                    passwordField.getText().trim(), token)) {
                System.out.println("Validated!");
                // also check is user wants to be remembered
                if(rememberMeToggle.isSelected()) {
                    // store user token
                    System.out.println("Remember me!");
                }
                return true;
            }
        }catch (Error e) {
            System.out.println(e.toString());
        }
        return false;
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