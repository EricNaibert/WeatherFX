package com.github.ericnaibert.weatherfx.favorite;

import com.github.ericnaibert.weatherfx.tools.StoragePath;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FavoriteCityReader {

    private static String cityInFile;

    public static String readFavorite() {

        StoragePath storagePath = new StoragePath();
        File file = storagePath.favoritePath();

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            DataInputStream inputStream = new DataInputStream(fileInputStream);

            cityInFile = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);

            inputStream.close();

        } catch (FileNotFoundException e) {
            System.out.println("readFavorite(): File Not Found! Exception: " + e);
        } catch (IOException e) {
            System.out.println("storeFavorite(): Could Not Read File! Exception: " + e);
        }

        return cityInFile;
    }

}
