package com.github.ericnaibert.weatherfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ApplicationInterface extends Application {

    public static Group root;
    public static TextField inputField;

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(ApplicationInterface.class.getResource("application-view.fxml"));

        String css = (Objects.requireNonNull(ApplicationInterface.class.getResource("application.css")).toExternalForm());

        root = new Group();
        root.getChildren().add(fxmlLoader.load());

        Controller fxmlController = fxmlLoader.getController();
        fxmlController.setGetHostController(getHostServices());

        inputField = new TextField();
        inputField.setPrefWidth(300);
        inputField.setMinWidth(300);
        inputField.setLayoutX(200);
        inputField.setLayoutY(40);

        root.getChildren().add(inputField);

        Scene scene = new Scene(root, 700, 500);
        scene.getStylesheets().add(css);
        stage.setResizable(false);
        stage.setTitle("Weather FX");
        stage.setScene(scene);
        stage.show();
    }

    @SuppressWarnings("unused")
    public static void init(String[] args) {
        launch();
    }
}