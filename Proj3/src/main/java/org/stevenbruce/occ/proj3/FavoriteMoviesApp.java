package org.stevenbruce.occ.proj3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class FavoriteMoviesApp extends Application {
    // Start method override to open the JavaFX application in a new window.
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FavoriteMoviesApp.class.getResource("favorite-movies-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Favorite Movies");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

