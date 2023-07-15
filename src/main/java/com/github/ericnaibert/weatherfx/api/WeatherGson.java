package com.github.ericnaibert.weatherfx.api;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("unused")
public class WeatherGson implements Serializable {

    private Location location;
    private Current current;
    private Forecast forecast;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public Forecast getForecast() {
        return forecast;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }

    public static class Location{
        public String name;
        public String region;
        public String country;

    }

    @SuppressWarnings("SpellCheckingInspection")
    public static class Current implements Serializable{

        @SerializedName("temp_c")
        public double temperature;
        @SerializedName("temp_f")
        public double temperatureF;
        public double humidity;
        @SerializedName("feelslike_c")
        public double feelsLike;
        @SerializedName("feelslike_f")
        public double feelsLikeF;
        public double uv;
        @SerializedName("wind_kph")
        public double windSpeed;
        @SerializedName("wind_dir")
        public String windDirection;


    }

    public static class Forecast implements Serializable {

        public ArrayList<Forecastday> forecastday;

        @SuppressWarnings("SpellCheckingInspection")
        public static class Forecastday implements Serializable {

            public Day day;

            public static class Day implements Serializable {

                @SerializedName("maxtemp_c")
                public double maxTemperatureC;
                @SerializedName("maxtemp_f")
                public double maxTemperatureF;
                @SerializedName("mintemp_c")
                public double minTemperatureC;
                @SerializedName("mintemp_f")
                public double minTemperatureF;
                @SerializedName("totalprecip_mm")
                public double precipitation;
                public Condition condition;

                public static class Condition implements Serializable{

                    @SerializedName("text")
                    public String currentWeatherText;

                    @SerializedName("icon")
                    public String currentWeatherIcon;

                }

            }

        }


    }

}
