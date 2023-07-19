package com.github.ericnaibert.weatherfx.data;

import com.github.ericnaibert.weatherfx.controllers.KeyHomeController;
import com.github.ericnaibert.weatherfx.Main;
import com.github.ericnaibert.weatherfx.ApplicationInterface;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Objects;

public class KeyHome extends ApplicationInterface {

    private static String key;
    public  static Scene homeScene;

    public void homePage() {

        KeyStorage keyStorage = new KeyStorage();

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("homepage-view.fxml"));

        String css = (Objects.requireNonNull(Main.class.getResource("application.css")).toExternalForm());

        Group homeRoot = new Group();
        try {
            homeRoot.getChildren().add(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }

        KeyHomeController keyHomeController = fxmlLoader.getController();
        keyHomeController.setHostServices(getHostServices());

        TextField textFieldKey = new TextField();
        textFieldKey.setLayoutX(50);
        textFieldKey.setLayoutY(100);
        textFieldKey.setPrefWidth(400);
        setKey(textFieldKey.getText());
        keyStorage.storeKey(getKey());

        homeRoot.getChildren().add(textFieldKey);

        homeScene = new Scene(homeRoot, 505, 305);
        homeScene.getStylesheets().add(css);
    }

    public static String getKey() {
        return key;
    }

    private static void setKey(String key) {
        KeyHome.key = key;
    }
}
