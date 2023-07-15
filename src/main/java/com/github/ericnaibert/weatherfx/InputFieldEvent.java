package com.github.ericnaibert.weatherfx;

import com.github.ericnaibert.weatherfx.api.WeatherConnection;
import com.github.ericnaibert.weatherfx.api.WeatherData;
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
        });

        weatherServer.setOnSucceeded(event1 -> {
            LoadingProgressHud.stage.close();
            WeatherData weatherData = new WeatherData();
            System.out.println(weatherData.getCurrentCityName());
            System.out.println(weatherData.getCurrentTemperatureC());
            System.out.println(weatherData.getMaxTemperatureC(0));
            System.out.println(weatherData.getForecastCityWeatherText(0));

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
