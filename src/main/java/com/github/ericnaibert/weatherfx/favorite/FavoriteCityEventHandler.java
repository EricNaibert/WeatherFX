package com.github.ericnaibert.weatherfx.favorite;


import javafx.scene.control.Button;

public class FavoriteCityEventHandler {

    public static void event(Button button) {

        if(!FavoriteCityNode.isFavorite()) {
            FavoriteCityStorage.storeFavorite();
            FavoriteCityNode.setFavoriteStarColor(2);
            FavoriteCityNode.setFavorite(true);

        } else {
            FavoriteCityStorage.deleteFavorite();
            FavoriteCityNode.setFavoriteStarColor(1);
            FavoriteCityNode.setFavorite(false);
        }
    }

}
