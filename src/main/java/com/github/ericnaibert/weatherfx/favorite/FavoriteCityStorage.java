package com.github.ericnaibert.weatherfx.favorite;

import com.github.ericnaibert.weatherfx.api.WeatherData;
import com.github.ericnaibert.weatherfx.tools.StoragePath;

import java.io.*;
import java.nio.file.Files;

public class FavoriteCityStorage {

    public static void storeFavorite() {

        WeatherData weatherData = new WeatherData();
        StoragePath storagePath = new StoragePath();
        File file = storagePath.favoritePath();

        try {
            FileOutputStream fileInputStream = new FileOutputStream(file);
            DataOutputStream outputStream = new DataOutputStream(fileInputStream);

            outputStream.writeBytes(weatherData.getCurrentCityName().replace(" ", "_"));
            outputStream.close();

        } catch (FileNotFoundException e) {
            System.out.println("storeFavorite(): File Not Found! Exception: " + e);
        } catch (IOException e) {
            System.out.println("storeFavorite(): Could not Write File! Exception: " + e);
        }

    }

    public static void deleteFavorite() {

        StoragePath storagePath = new StoragePath();
        File file = storagePath.favoritePath();

        try {
            Files.delete(file.toPath());


        } catch (IOException e) {
            System.out.println("deleteFavorite(): File Not Found! Exception: " + e);
        }

    }

}
