package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load( getClass().getResource("views/login.fxml") );

        Scene scene = new Scene(root, 800, 600);

        final ObservableList<String> stylesheets = scene.getStylesheets();
        stylesheets.addAll(Main.class.getResource("/sample/assets/css/jfoenix/jfoenix-design.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setTitle("Feeder App - alpha v0.1");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
