package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private Stage stage;
    private static Main instance;

    public Main()
    {
        instance = this;
    }

    public static Main getInstance()
    {
        return instance;
    }

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        try {
            stage = primaryStage;
            gotoLogin();
            primaryStage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
//        Parent root = FXMLLoader.load( getClass().getResource("views/login.fxml") );
//
//        Scene scene = new Scene(root, 800, 600);
//
//        final ObservableList<String> stylesheets = scene.getStylesheets();
//        stylesheets.addAll(Main.class.getResource("/sample/assets/css/jfoenix/jfoenix-design.css").toExternalForm());
//
//        primaryStage.setScene(scene);
//        primaryStage.setTitle("Feeder App - alpha v0.1");
//        primaryStage.show();
    }

    public void loginUser(){
        gotoProfile();
    }

    private void gotoLogin()
    {
        try {
            replaceSceneContent("views/login.fxml");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void gotoProfile()
    {
        try {
            replaceSceneContent("views/profile.fxml");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private Parent replaceSceneContent(String fxml) throws Exception
    {
        Parent page = (Parent) FXMLLoader.load(Main.class.getResource(fxml), null, new JavaFXBuilderFactory());
        Scene scene = stage.getScene();
        if (scene == null) {
            scene = new Scene(page, 800, 900);
            scene.getStylesheets().add(Main.class.getResource("/sample/assets/css/main-style.css").toExternalForm());
            stage.setTitle("Feeder");
            stage.setScene(scene);
        } else {
            stage.getScene().setRoot(page);
        }
        stage.sizeToScene();
        return page;
    }
}
