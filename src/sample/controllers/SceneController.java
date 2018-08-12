package sample.controllers;

public class SceneController {
    private static String landingView = "views/login.fxml";
    private String activeScene = landingView;

    public void setActiveScene(String activeScene) {
        this.activeScene = activeScene;
    }

    public String getScene() {
        return this.activeScene;
    }
}
