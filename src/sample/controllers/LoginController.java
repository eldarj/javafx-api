package sample.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import sample.Main;

public class LoginController {
    @FXML private JFXTextField usernameField;
    @FXML private JFXPasswordField passwordField;
    @FXML private JFXButton loginButton, cancelButton;
    @FXML private JFXToggleButton rememberMeToggle;
    @FXML private Label userDataLabel;

    @FXML public void initialize() {
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
    @FXML public void onButtonClicked(ActionEvent e) {
        // check the clicked button
        if (e.getSource().equals(loginButton)) {
            if(this.loginUser()) {
                Main.getInstance().loginUser();
            }
        } else if (e.getSource().equals(cancelButton)) {
            this.cancelLogin();
        }
    }

    /**
     * Login handler
     */
    private boolean loginUser() {
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();
        String token = "yvj192f";
        boolean rememberMe = rememberMeToggle.isSelected();

        Runnable loginTask = new Runnable() {
            @Override
            public void run() {
                try {
                    String platformThread = Platform.isFxApplicationThread() ? "UI Thread" : "Background Thread";
                    System.out.println("Working at " + platformThread);
                    Thread.sleep(500);
                    if (validateFromApi(username,password, token)) {
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                String platformThread = Platform.isFxApplicationThread() ? "UI Thread" : "Background Thread";
                                System.out.println("Working at " + platformThread);
                                System.out.println("Validated!");
                                // also check is user wants to be remembered
                                if(rememberMe) {
                                    // store user token
                                    System.out.println("Remember me!");
                                }
                                userDataLabel.setText("Welcome " + username + ":" + password + " @" + token);
                            }
                        });
                    }
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(loginTask).start();
        return true;
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