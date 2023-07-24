package com.github.ericnaibert.weatherfx.api;

import com.google.gson.Gson;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class WeatherData {

    private static String currentCityName;
    private static String currentRegion;
    private static String currentCountry;
    private static double currentTemperatureC;
    private static double currentTemperatureF;
    private static double currentFeelsLikeC;
    private static double currentFeelsLikeF;
    private static double currentCityHumidity;
    private static double currentWindSpeed;
    private static String currentWindDirection;
    private static double currentCityUV;
    private static final ArrayList<String> forecastCityWeatherText = new ArrayList<>();
    private static final ArrayList<String> forecastCityWeatherIcon = new ArrayList<>();
    private static final ArrayList<Double> maxTemperatureC = new ArrayList<>();
    private static final ArrayList<Double> maxTemperatureF = new ArrayList<>();
    private static final ArrayList<Double> minTemperatureC = new ArrayList<>();
    private static final ArrayList<Double> minTemperatureF = new ArrayList<>();
    private static final ArrayList<Double> dayPrecipitation = new ArrayList<>();

    public void storeData(StringBuilder informationFromJson) {

        String[] infoStringArray = new String[]{String.valueOf(informationFromJson)};
        String temp = infoStringArray[0];

        Gson gson = new Gson();
        WeatherGson weatherInfoJson = gson.fromJson(temp, WeatherGson.class);

        setCurrentCityName(weatherInfoJson.getLocation().name);
        setCurrentRegion(weatherInfoJson.getLocation().region);
        setCurrentCountry(weatherInfoJson.getLocation().country);

        setCurrentTemperatureC(weatherInfoJson.getCurrent().temperature);
        setCurrentTemperatureF(weatherInfoJson.getCurrent().temperatureF);
        setCurrentFeelsLikeC(weatherInfoJson.getCurrent().feelsLikeF);
        setCurrentFeelsLikeF(weatherInfoJson.getCurrent().feelsLike);
        setCurrentCityHumidity(weatherInfoJson.getCurrent().humidity);
        setCurrentWindSpeed(weatherInfoJson.getCurrent().windSpeed);
        setCurrentWindDirection(weatherInfoJson.getCurrent().windDirection);
        setCurrentCityUV(weatherInfoJson.getCurrent().uv);

        for(int i = 0; i <=2 ; i++) {

            setForecastCityWeatherText(weatherInfoJson.getForecast().forecastday.get(i).day.condition.currentWeatherText);
            setForecastCityWeatherIcon(weatherInfoJson.getForecast().forecastday.get(i).day.condition.currentWeatherIcon);
            setMaxTemperatureC(weatherInfoJson.getForecast().forecastday.get(i).day.maxTemperatureC);
            setMaxTemperatureF(weatherInfoJson.getForecast().forecastday.get(i).day.maxTemperatureF);
            setMinTemperatureC(weatherInfoJson.getForecast().forecastday.get(i).day.minTemperatureC);
            setMinTemperatureF(weatherInfoJson.getForecast().forecastday.get(i).day.minTemperatureF);
            setDayPrecipitation(weatherInfoJson.getForecast().forecastday.get(i).day.precipitation);
        }
    }

    public static void clearData() {
        WeatherData.forecastCityWeatherText.clear();
        WeatherData.forecastCityWeatherIcon.clear();
        WeatherData.maxTemperatureC.clear();
        WeatherData.maxTemperatureF.clear();
        WeatherData.minTemperatureC.clear();
        WeatherData.minTemperatureF.clear();
        WeatherData.dayPrecipitation.clear();
    }

    public String getCurrentCityName() {
        return currentCityName;
    }

    public void setCurrentCityName(String currentCityName) {
        WeatherData.currentCityName = currentCityName;
    }

    public String getCurrentRegion() {
        return currentRegion;
    }

    public void setCurrentRegion(String currentRegion) {
        WeatherData.currentRegion = currentRegion;
    }

    public String getCurrentCountry() {
        return currentCountry;
    }

    public void setCurrentCountry(String currentCountry) {
        WeatherData.currentCountry = currentCountry;
    }

    public double getCurrentTemperatureC() {
        return currentTemperatureC;
    }

    public void setCurrentTemperatureC(double currentTemperatureC) {
        WeatherData.currentTemperatureC = currentTemperatureC;
    }

    public double getCurrentTemperatureF() {
        return currentTemperatureF;
    }

    public void setCurrentTemperatureF(double currentTemperatureF) {
        WeatherData.currentTemperatureF = currentTemperatureF;
    }

    public double getCurrentFeelsLikeC() {
        return currentFeelsLikeC;
    }

    public void setCurrentFeelsLikeC(double currentFeelsLikeC) {
        WeatherData.currentFeelsLikeC = currentFeelsLikeC;
    }

    public double getCurrentFeelsLikeF() {
        return currentFeelsLikeF;
    }

    public void setCurrentFeelsLikeF(double currentFeelsLikeF) {
        WeatherData.currentFeelsLikeF = currentFeelsLikeF;
    }

    public double getCurrentCityHumidity() {
        return currentCityHumidity;
    }

    public void setCurrentCityHumidity(double currentCityHumidity) {
        WeatherData.currentCityHumidity = currentCityHumidity;
    }

    public double getCurrentWindSpeed() {
        return currentWindSpeed;
    }

    public void setCurrentWindSpeed(double currentWindSpeed) {
        WeatherData.currentWindSpeed = currentWindSpeed;
    }

    public String getCurrentWindDirection() {
        return currentWindDirection;
    }

    public void setCurrentWindDirection(String currentWindDirection) {
        WeatherData.currentWindDirection = currentWindDirection;
    }

    public double getCurrentCityUV() {
        return currentCityUV;
    }

    public void setCurrentCityUV(double currentCityUV) {
        WeatherData.currentCityUV = currentCityUV;
    }

    public String getForecastCityWeatherText(int index) {
        return forecastCityWeatherText.get(index);
    }

    public void setForecastCityWeatherText(String forecastCityWeatherText) {
        WeatherData.forecastCityWeatherText.add(forecastCityWeatherText);
    }

    public String getForecastCityWeatherIcon(int index) {
        return forecastCityWeatherIcon.get(index);

    }

    public void setForecastCityWeatherIcon(String forecastCityWeatherIcon) {
        WeatherData.forecastCityWeatherIcon.add(forecastCityWeatherIcon);
    }

    public Double getMaxTemperatureC(int index) {
        return maxTemperatureC.get(index);
    }

    public void setMaxTemperatureC(Double maxTemperatureC) {
        WeatherData.maxTemperatureC.add(maxTemperatureC);
    }

    public Double getMaxTemperatureF(int index) {
        return maxTemperatureF.get(index);
    }

    public void setMaxTemperatureF(Double maxTemperatureF) {
        WeatherData.maxTemperatureF.add(maxTemperatureF);
    }

    public Double getMinTemperatureC(int index) {
        return minTemperatureC.get(index);
    }

    public void setMinTemperatureC(Double minTemperatureC) {
        WeatherData.minTemperatureC.add(minTemperatureC);
    }

    public Double getMinTemperatureF(int index) {
        return minTemperatureF.get(index);
    }

    public void setMinTemperatureF(Double minTemperatureF) {
        WeatherData.minTemperatureF.add(minTemperatureF);
    }

    public Double getDayPrecipitation(int index) {
        return dayPrecipitation.get(index);
    }

    public void setDayPrecipitation(Double dayPrecipitation) {
        WeatherData.dayPrecipitation.add(dayPrecipitation);
    }
}
