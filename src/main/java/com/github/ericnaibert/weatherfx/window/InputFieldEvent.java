package com.github.ericnaibert.weatherfx.window;

import com.github.ericnaibert.weatherfx.ApplicationInterface;
import com.github.ericnaibert.weatherfx.tools.LoadingProgressHud;
import com.github.ericnaibert.weatherfx.api.WeatherConnection;
import javafx.scene.input.KeyCode;

import java.text.Normalizer;
import java.util.Arrays;

public class InputFieldEvent {

    public static String cityName;

    public static void event() {

        ApplicationInterface.inputField.setOnKeyPressed(event -> {

            if (event.getCode() == KeyCode.ENTER) {

                //ApplicationInterface.root.getChildren().removeAll(resultStorage);

                String temp = ApplicationInterface.inputField.getText();
                String[] storeName = temp.split(" ");
                cityName = inputFilter(removeWhitespaces(storeName));

                invokeWeatherTask();

                ApplicationInterface.inputField.clear();
                ApplicationInterface.inputField.requestFocus();

            }
        });
    }

    public static void invokeWeatherTask() {
        WeatherConnection weatherServer = new WeatherConnection();
        Thread thread = new Thread(weatherServer);
        thread.setDaemon(true);
        thread.start();

        weatherServer.setOnRunning(event1 -> {
            LoadingProgressHud.progressLoadingHub();
            LoadingProgressHud.stage.show();
            ApplicationInterface.root.getChildren().removeAll(NodeStorage.getNodeStorageList());
        });

        weatherServer.setOnSucceeded(event1 -> {
            LoadingProgressHud.stage.close();
            CurrentWeatherNodes.nodesToScreen();
            ForecastWeatherNodes.nodesToScreen();

        });
    }

    public static String inputFilter(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }

    public static String removeWhitespaces(String[] array) {
        String rawString;

        if(array.length == 2) {
            rawString = array[0] + "_" + array[1];
        } else if(array.length == 3) {
            rawString = array[0] + "_" + array[1] + "_" + array[2];
        } else if(array.length >= 4) {
            rawString = array[0] + "_" + array[1] + "_" + array[2] + "_" + array[3];
        } else {
            rawString = Arrays.toString(array);
        }

        return rawString;
    }

}
