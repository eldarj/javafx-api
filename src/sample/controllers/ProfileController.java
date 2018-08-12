package sample.controllers;

import com.jfoenix.controls.JFXTextArea;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import sample.datamodels.Profile;

public class ProfileController {
    private Profile myProfile = new Profile();

    @FXML
    private Label shortDescription, profileImage, profileCover;

    @FXML public void initialize() {
        shortDescription.setText(myProfile.getShortDescription());
        profileImage.setText(myProfile.getProfileImage());
        profileCover.setText(myProfile.getProfileCover());
    }
}
