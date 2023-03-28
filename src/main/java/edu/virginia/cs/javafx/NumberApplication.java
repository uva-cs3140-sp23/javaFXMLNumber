package edu.virginia.cs.javafx;

import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NumberApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(NumberApplication.class.getResource("number-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Number Application");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
