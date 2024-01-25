/*
 * Course: CSC4641
 * Naive Autocomplete
 */
package edu.msoe.jones.autocomplete;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * Controller class for auto-complete
 */
public class Controller {
    @FXML
    private TextField input;
    @FXML
    private ListView<String> view;

    @FXML
    private void complete() {
        final int minLength = 3;
        String text = input.getText();
        if(text.length() >= minLength) {
            view.setItems(Autocomplete.complete(text));
        }
    }
}