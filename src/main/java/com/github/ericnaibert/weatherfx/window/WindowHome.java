package com.github.ericnaibert.weatherfx.window;

import com.github.ericnaibert.weatherfx.ApplicationInterface;
import com.github.ericnaibert.weatherfx.Main;
import com.github.ericnaibert.weatherfx.api.InvokeTask;
import com.github.ericnaibert.weatherfx.controllers.WindowHomeController;
import com.github.ericnaibert.weatherfx.favorite.FavoriteCityNode;
import com.github.ericnaibert.weatherfx.favorite.FavoriteCityReader;
import com.github.ericnaibert.weatherfx.tools.StoragePath;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class WindowHome extends ApplicationInterface {

    public static Scene scene;

    public void weatherHome() {

        StoragePath storagePath = new StoragePath();
        File favoriteFilePath = storagePath.favoritePath();

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("application-view.fxml"));

        String css = (Objects.requireNonNull(Main.class.getResource("application.css")).toExternalForm());

        root = new Group();
        try {
            root.getChildren().add(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }

        WindowHomeController windowHomeController = fxmlLoader.getController();
        windowHomeController.setGetHostController(getHostServices());
        WindowInputFieldEvent inputFieldEvent = new WindowInputFieldEvent();

        inputField = new TextField();
        inputField.setPrefWidth(300);
        inputField.setMinWidth(300);
        inputField.setLayoutX(200);
        inputField.setLayoutY(40);
        inputField.setOnAction(inputFieldEvent.eventHandler(inputField));
        root.getChildren().add(inputField);

        if(favoriteFilePath.exists() && !FavoriteCityReader.readFavorite().isEmpty()) {
            InvokeTask.invokeWeatherTask(FavoriteCityReader.readFavorite());
            FavoriteCityNode.setFavoriteStarColor(2);
            FavoriteCityNode.setFavorite(true);
        } else {
            FavoriteCityNode.setFavoriteStarColor(1);
        }

        scene = new Scene(root, 700, 500);
        scene.getStylesheets().add(css);

    }
}
