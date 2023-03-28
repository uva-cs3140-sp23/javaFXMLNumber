package edu.virginia.cs.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Calculator");

        Label label = new Label("Enter a number: ");
        TextField input = new TextField("");
        Label result = new Label("");

        // Add a new feature: count the number of time user uses the app
        Label countLabel = new Label("Use: 0 time.");
        AtomicInteger count = new AtomicInteger(0);


        Button button = new Button("Calculate Square Root");
        button.setOnAction(e -> { //lambda function
            try{
                double x = Double.parseDouble(input.getText());
                double sqrt = Math.sqrt(x);
                result.setText("Answer is " + sqrt);
                count.incrementAndGet();
                countLabel.setText("Use: " + count.intValue() + " times");
            }catch(NumberFormatException exception) {
                result.setText("Invalid input. Please enter again!");
            }

        });

        FlowPane root = new FlowPane();

        Button darkMode = new Button("Dark Mode");
        darkMode.setOnAction(e -> {
            root.setStyle("-fx-background-color: #333333");
            label.setStyle("-fx-text-fill: #FFFFFF");
            result.setStyle("-fx-text-fill: #FFFFFF");
            countLabel.setStyle("-fx-text-fill: #FFFFFF");
        });

        Button lightMode = new Button("Light Mode");
        lightMode.setOnAction(e -> {
            root.setStyle("-fx-background-color: #FFFFFF");
            label.setStyle("-fx-text-fill: #333333");
            result.setStyle("-fx-text-fill: #333333");
            countLabel.setStyle("-fx-text-fill: #333333");
        });




        root.getChildren().addAll(label, input, button, result, countLabel, darkMode, lightMode);

        root.setHgap(10);
        root.setVgap(10);

        Scene scene = new Scene (root, 500, 300);
        stage.setScene(scene);
        stage.show(); // app visible


    }

    public static void main(String[] args) {
        launch();
    }
}