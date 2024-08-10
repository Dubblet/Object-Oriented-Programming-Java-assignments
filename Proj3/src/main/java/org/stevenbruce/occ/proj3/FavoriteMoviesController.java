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
    @FXML
    private ListView listOfMovies;
    @FXML
    private TextField txtNameEnter;
    @FXML
    private Label deleteBtnReminder;

    File saveFile = new File("movies.txt");
    ObservableList<String> movieList = FXCollections.observableArrayList();

    public void initialize() {
        listOfMovies.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listOfMovies.setItems(movieList);
    }

    @FXML
    protected void onClickAdd(ActionEvent event) {
        movieList.add(txtNameEnter.getText().toLowerCase().trim());
        txtNameEnter.setText("");
    }

    @FXML
    protected void onClickRemove(ActionEvent event) {
        ObservableList<Integer> selectedIndices = listOfMovies.getSelectionModel().getSelectedIndices();
        if (!selectedIndices.isEmpty()) {
            for (int i = selectedIndices.size() - 1; i >= 0; i--) {
                listOfMovies.getItems().remove((int) selectedIndices.get(i));
            }
        } else {
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

    @FXML
    protected void onClickSave(ActionEvent event) throws IOException {
        if (saveFile.exists()) {
            Files.write(saveFile.toPath(), listOfMovies.getItems());
        } else {
            saveFile.createNewFile();
            Files.write(saveFile.toPath(), listOfMovies.getItems());
        }
    }

    @FXML
    protected void onClickLoad(ActionEvent event) throws IOException {
        if (saveFile.exists()) {
            listOfMovies.getItems().clear();
            List<String> loadingFile = Files.readAllLines(saveFile.toPath());
            listOfMovies.getItems().addAll(loadingFile);
        }
    }
}
