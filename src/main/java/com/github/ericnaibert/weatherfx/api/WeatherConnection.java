package com.github.ericnaibert.weatherfx.api;

import com.github.ericnaibert.weatherfx.data.KeyReader;
import javafx.concurrent.Task;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

public class WeatherConnection extends Task<Void> {

    private static String cityName;

    public static Void httpsConnection() {

        String accessKey = KeyReader.getAccessKey();
        WeatherConnection weatherConnection = new WeatherConnection();

        try {

            String cityURL = "&q=" + weatherConnection.getCityName() + "&days=3&aqi=no&alerts=no";

            String url = "http://api.weatherapi.com/v1/forecast.json?key=" + accessKey + cityURL;

            URL weatherURL = new URI(url).toURL();

            HttpURLConnection connection = (HttpURLConnection) weatherURL.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            if(connection.getResponseCode() != 200) {
                throw new RuntimeException("HTTP RESPONSE: " + connection.getResponseCode());
            } else {
                StringBuilder informationFromJson = new StringBuilder();
                Scanner scanner = new Scanner(weatherURL.openStream());

                while (scanner.hasNext()) {
                    informationFromJson.append(scanner.nextLine());
                }

                WeatherData.clearData();
                WeatherData weatherData = new WeatherData();
                weatherData.storeData(informationFromJson);

                scanner.close();

            }

        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        WeatherConnection.cityName = cityName;
    }

    @Override
    protected Void call() {

        return WeatherConnection.httpsConnection();
    }
}
