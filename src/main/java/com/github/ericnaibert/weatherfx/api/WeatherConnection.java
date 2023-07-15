package com.github.ericnaibert.weatherfx.api;

import javafx.concurrent.Task;

import javax.net.ssl.HttpsURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

public class WeatherConnection extends Task<Void> {

    public static Void httpsConnection() {

        String cityName = "London";

        try {

            AccessKey accessKey = new AccessKey();
            String cityURL = "&q=" + cityName + "&days=3&aqi=no&alerts=no";

            String url = "https://api.weatherapi.com/v1/forecast.json?key=" + accessKey.getKey() + cityURL;

            URL weatherURL = new URI(url).toURL();

            HttpsURLConnection connection = (HttpsURLConnection) weatherURL.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            if(connection.getResponseCode() != 200) {
                throw new RuntimeException("HTTPS RESPONSE: " + connection.getResponseCode());
            } else {
                StringBuilder informationFromJson = new StringBuilder();
                Scanner scanner = new Scanner(weatherURL.openStream());

                while (scanner.hasNext()) {
                    informationFromJson.append(scanner.nextLine());
                }

                WeatherData weatherData = new WeatherData();
                weatherData.storeData(informationFromJson);

                scanner.close();

            }

        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected Void call() {

        return WeatherConnection.httpsConnection();
    }
}
