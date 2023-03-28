package edu.virginia.cs.javafx;

import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class NumberController {
    private NumberModel model;

    @FXML
    private Label errorLabel;
    @FXML
    private TextField entryTextArea;
    @FXML
    private Label isOddLabel;
    @FXML
    private Label isEvenLabel;
    @FXML
    private Label isPrimeLabel;
    @FXML
    private Label isSquareLabel;


    public NumberController() {
        model = new NumberModel();
    }

    @FXML
    protected void handleBackButton() {
        try {
            errorLabel.setText("");
            model.previous();

        } catch (RuntimeException e) {
            errorLabel.setText("Can't use Back Button right now");
            return;
        }
        updateAllLabelsForCurrentNumber();
    }

    @FXML
    protected void handleNextButtonGUI() {
        try {
            model.next();
            errorLabel.setText("");

        } catch (RuntimeException e) {
            errorLabel.setStyle("-fx-background-color: red; -fx-text-fill: white");
            errorLabel.setText("Can't use Forward Button right now");
            return;
        }
        updateAllLabelsForCurrentNumber();
    }

    @FXML
    protected void onTextEntryEnter(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            try {
                entryTextArea.setText(entryTextArea.getText().strip());
                errorLabel.setText("");
                int value = Integer.parseInt(entryTextArea.getText());
                model.addNumber(value);
                updateAllLabelsForCurrentNumber();
            } catch (NumberFormatException e) {
                errorLabel.setText("Error: Enter a valid int");
            }
        }
    }

    private void updateAllLabelsForCurrentNumber() {
        entryTextArea.setText(Integer.toString(model.getCurrentNumber()));
        updateLabel(isOddLabel, model.currentNumberIsOdd());
        updateLabel(isEvenLabel, model.currentNumberIsEven());
        updateLabel(isPrimeLabel, model.currentNumberIsPrime());
        updateLabel(isSquareLabel, model.currentNumberIsSquare());
    }

    private void updateLabel(Label label, boolean result) {
        label.setText(Boolean.toString(result));
    }
}
