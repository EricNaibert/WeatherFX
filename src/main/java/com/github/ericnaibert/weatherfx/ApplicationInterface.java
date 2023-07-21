package com.github.ericnaibert.weatherfx;

import com.github.ericnaibert.weatherfx.data.KeyHome;
import com.github.ericnaibert.weatherfx.data.KeyReader;
import com.github.ericnaibert.weatherfx.window.WindowHome;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;

public class ApplicationInterface extends Application {

    public static Group root;
    public static TextField inputField;

    @Override
    public void start(Stage stage) {

        String userHome = System.getProperty("user.home");
        String path = userHome + File.separator + "WeatherFX" + File.separator + "WeatherConfig.wfx";
        File file = new File(path);

        stage.setResizable(false);
        stage.setTitle("Weather FX");

        KeyHome keyHome = new KeyHome();
        WindowHome windowHome = new WindowHome();

        if(file.exists()) {
            KeyReader.keyReader();
            windowHome.weatherHome();
            stage.setScene(WindowHome.scene);
            stage.show();
        } else {
            keyHome.homePage();
            stage.setScene(KeyHome.homeScene);
            stage.show();
        }

    }

    @SuppressWarnings("unused")
    public static void init(String[] args) {
        launch();
    }
}