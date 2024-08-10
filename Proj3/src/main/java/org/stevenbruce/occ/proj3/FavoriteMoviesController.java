package org.stevenbruce.occ.proj3;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FavoriteMoviesController {
    // FXML IDs
    @FXML
    private ListView listOfMovies;
    @FXML
    private TextField txtNameEnter;
    @FXML
    private Label deleteBtnReminder;

    // Create a filename to be saved and an ObservableList to be used in updating the ListView.
    File saveFile = new File("movies.txt");
    ObservableList<String> movieList = FXCollections.observableArrayList();

    // Sets the ListView to allow multiple selections. Update it with changes to the observable movieList.
    public void initialize() {
        listOfMovies.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listOfMovies.setItems(movieList);
    }

    /**
     * Takes the textfield input and adds it to the Observable movieList, which also updates the ListView.
     * @param event When the 'Add' button is clicked.
     */
    @FXML
    protected void onClickAdd(ActionEvent event) {
        movieList.add(txtNameEnter.getText().toLowerCase().trim());
        txtNameEnter.setText("");
    }

    /**
     * Removes the selected row(s) from the listView of movies.
     * @param event When the 'Remove' button is clicked.
     */
    @FXML
    protected void onClickRemove(ActionEvent event) {
        ObservableList<Integer> selectedIndices = listOfMovies.getSelectionModel().getSelectedIndices();
        if (!selectedIndices.isEmpty()) {
            // Works backwards through the list, and removes the row if its index matches one that was selected.
            for (int i = selectedIndices.size() - 1; i >= 0; i--) {
                listOfMovies.getItems().remove((int) selectedIndices.get(i));
            }
        } else {
            // If no rows are selected, make a reminder visible for 3 seconds then hide it again.
            Timeline reminder = new Timeline(
                    new KeyFrame(Duration.ZERO,
                            e -> {
                        deleteBtnReminder.setVisible(true);
                            }),
                    new KeyFrame(Duration.seconds(3),
                            e -> {
                        deleteBtnReminder.setVisible(false);
                            })
            );
            reminder.playFromStart();
        }
    }

    /**
     * Creates or overwrites the 'movies.txt' file with what is currently in the ListView of movies.
     * @param event When the 'Save' button is clicked.
     * @throws IOException
     */
    @FXML
    protected void onClickSave(ActionEvent event) throws IOException {
        if (saveFile.exists()) {
            Files.write(saveFile.toPath(), listOfMovies.getItems());
        } else {
            saveFile.createNewFile();
            Files.write(saveFile.toPath(), listOfMovies.getItems());
        }
    }

    /**
     * Loads the 'movies.txt' file, replacing with what is currently in the ListView of movies with the file's contents.
     * @param event When the 'Load' button is clicked.
     * @throws IOException
     */
    @FXML
    protected void onClickLoad(ActionEvent event) throws IOException {
        if (saveFile.exists()) {
            listOfMovies.getItems().clear();
            List<String> loadingFile = Files.readAllLines(saveFile.toPath());
            listOfMovies.getItems().addAll(loadingFile);
        }
    }
}
