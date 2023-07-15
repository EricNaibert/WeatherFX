package com.github.ericnaibert.weatherfx;

import com.google.gson.Gson;
import javafx.concurrent.Task;

import javax.net.ssl.HttpsURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class WeatherServer extends Task<Void> {

    public static String getCityName;
    public static String getCityRegion;
    public static String getCityCountry;
    public static double getCityTemperature;
    public static double getCityTemperatureF;
    public static double getCityFeelsLike;
    public static double getCityFeelsLikeF;
    public static double getCityHumidity;
    public static double getWindSpeed;
    public static String getWindDirection;
    public static double getCityUV;
    public static ArrayList<String> forecastCityWeatherText = new ArrayList<>();
    public static ArrayList<String> forecastCityWeatherIcon = new ArrayList<>();
    public static ArrayList<Double> maxTemperatureC = new ArrayList<>();
    public static ArrayList<Double> maxTemperatureF = new ArrayList<>();
    public static ArrayList<Double> minTemperatureC = new ArrayList<>();
    public static ArrayList<Double> minTemperatureF = new ArrayList<>();
    public static ArrayList<Double> dayPrecipitation = new ArrayList<>();

    public static Void weatherRequest() {

        System.out.println("PROGRESS 5%");

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
                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(weatherURL.openStream());

                while (scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }

                scanner.close();

                String[] infoStringArray = new String[]{String.valueOf(informationString)};
                String temp = infoStringArray[0];

                Gson gson = new Gson();
                WeatherInfoJson weatherInfoJson = gson.fromJson(temp, WeatherInfoJson.class);

                System.out.println("PROGRESS 40%");

                getCityName = weatherInfoJson.getLocation().name;
                getCityRegion = weatherInfoJson.getLocation().region;
                getCityCountry = weatherInfoJson.getLocation().country;

                getCityTemperature = weatherInfoJson.getCurrent().temperature;
                getCityTemperatureF = weatherInfoJson.getCurrent().temperatureF;
                getCityFeelsLikeF = weatherInfoJson.getCurrent().feelsLikeF;
                getCityFeelsLike = weatherInfoJson.getCurrent().feelsLike;
                getCityHumidity = weatherInfoJson.getCurrent().humidity;
                getWindSpeed = weatherInfoJson.getCurrent().windSpeed;
                getWindDirection = weatherInfoJson.getCurrent().windDirection;
                getCityUV = weatherInfoJson.getCurrent().uv;

                for(int i = 0; i <=2 ; i++) {
                    forecastCityWeatherText.add(weatherInfoJson.getForecast().forecastday.get(i).day.condition.currentWeatherText);
                    forecastCityWeatherIcon.add(weatherInfoJson.getForecast().forecastday.get(i).day.condition.currentWeatherIcon);
                    maxTemperatureC.add(weatherInfoJson.getForecast().forecastday.get(i).day.maxTemperatureC);
                    maxTemperatureF.add(weatherInfoJson.getForecast().forecastday.get(i).day.maxTemperatureF);
                    minTemperatureC.add(weatherInfoJson.getForecast().forecastday.get(i).day.minTemperatureC);
                    minTemperatureF.add(weatherInfoJson.getForecast().forecastday.get(i).day.minTemperatureF);
                    dayPrecipitation.add(weatherInfoJson.getForecast().forecastday.get(i).day.precipitation);
                }

            }
            System.out.println("PROGRESS 100%");

        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected Void call() throws Exception {

        return WeatherServer.weatherRequest();
    }
}
