package edu.virginia.cs.javafx;

import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class NumberApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        URL view = NumberApplication.class.getResource("number-view.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(view);
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("My Number Application");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
