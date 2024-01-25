/*
 * Course: CSC4641
 * Naive Autocomplete
 */
package edu.msoe.jones.autocomplete;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * A simple auto-completer that starts recommending completions when a word is at least
 * three characters long
 */
public class Autocomplete extends Application {
    private static final List<String> DICTIONARY = new ArrayList<>();
    private static final Path DICTIONARY_PATH = Paths.get("data", "words.txt");
    public static void main(String[] args) {
        // read in dictionary reference file
        try(Scanner read = new Scanner(DICTIONARY_PATH)) {
            while(read.hasNext()) {
                DICTIONARY.add(read.next());
            }
            // sort the dictionary alphabetically
            DICTIONARY.sort(Comparator.naturalOrder());
            launch(args);
        } catch(IOException e) {
            System.err.println("Cannot load dictionary");
        }
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("autocomplete.fxml"));
        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.setTitle("Auto-Completer");
        stage.show();
    }

    /**
     * Finds all the words in the dictionary that begin with the prefix
     * @param prefix the starting characters of the words to be recommended
     * @return a list of the words beginning with the prefix
     */
    public static ObservableList<String> complete(String prefix) {
        int start = getStartIndex(prefix);
        int end;
        if(start >= 0) {
            end = getEndIndex(start, prefix);
            return FXCollections.observableList(DICTIONARY.subList(start, end));
        }
        return FXCollections.observableList(new ArrayList<>());
    }

    private static int getStartIndex(String text) {
        boolean found = false;
        int result = -1;
        for(int i = 0; i < DICTIONARY.size() && !found; ++i) {
            if(DICTIONARY.get(i).startsWith(text)) {
                found = true;
                result = i;
            }
        }
        return result;
    }

    private static int getEndIndex(int start, String text) {
        boolean done = false;
        int result = start;
        for(int i = start + 1; i < DICTIONARY.size() && !done; ++i) {
            if(!DICTIONARY.get(i).startsWith(text)) {
                done = true;
                result = i;
            }
        }
        return result;
    }
}
