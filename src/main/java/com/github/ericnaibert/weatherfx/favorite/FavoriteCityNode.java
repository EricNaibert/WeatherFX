package com.github.ericnaibert.weatherfx.favorite;

import com.github.ericnaibert.weatherfx.ApplicationInterface;
import com.github.ericnaibert.weatherfx.api.WeatherData;
import com.github.ericnaibert.weatherfx.tools.StoragePath;
import com.github.ericnaibert.weatherfx.window.NodeStorage;
import javafx.scene.control.Button;

import java.util.Locale;

public class FavoriteCityNode extends ApplicationInterface {

    private static boolean favorite = false;

    private static final Button favoriteButton = new Button();

    public static void favoriteButton(double locationX, double locationY) {
        WeatherData weatherData = new WeatherData();
        StoragePath storagePath = new StoragePath();

        favoriteButton.setLayoutX(locationX);
        favoriteButton.setLayoutY(locationY);
        favoriteButton.setPrefWidth(28);
        favoriteButton.setPrefHeight(28);

        if(storagePath.favoritePath().exists() && FavoriteCityReader.readFavorite() != null) {
            String favoriteInFile = FavoriteCityReader.readFavorite().toLowerCase(Locale.ROOT).replace("_", "");
            String favoriteInCloud = weatherData.getCurrentCityName().toLowerCase().replace(" ", "");

            if (!favoriteInFile.equals(favoriteInCloud)) {
                setFavoriteStarColor(1);
            } else {
                setFavoriteStarColor(2);
            }
        }
        favoriteButton.setOnMouseClicked(event -> FavoriteCityEventHandler.event(favoriteButton));

        NodeStorage.addToNodeStorageList(favoriteButton);
        root.getChildren().add(favoriteButton);
    }

    public static void setFavoriteStarColor(int color) {
        FavoriteCityNode.favoriteButton.setBackground(FavoriteCityIcon.getStarImage(color));
    }

    public static boolean isFavorite() {
        return favorite;
    }

    public static void setFavorite(boolean favorite) {
        FavoriteCityNode.favorite = favorite;
    }
}