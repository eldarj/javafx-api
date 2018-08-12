package sample.controllers;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;

public class Controller {
    @FXML
    private JFXTextField usernameField,
                         passwordField;

    /**
     * Login page button click handler
     */
    public void onLoginUser() {
        // send data to api for validation
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
     * Validates user from WebAPI
     * @param username string from input
     * @param password string from input
     * @param token string from input
     * @return
     */
    public boolean validateFromApi(String username, String password, String token) {
        return true;
    }
}
