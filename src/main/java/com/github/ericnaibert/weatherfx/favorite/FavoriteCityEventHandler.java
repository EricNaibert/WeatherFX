package com.github.ericnaibert.weatherfx.favorite;


import javafx.scene.control.Button;

public class FavoriteCityEventHandler {

    public static void event(Button button) {

        if(!FavoriteCityNode.isFavorite) {
            System.out.println("FAVORITE");
            button.setBackground(FavoriteCityIcon.getStarImage(2));
            FavoriteCityNode.isFavorite = true;
        } else {
            System.out.println("NOT FAVORITE");
            button.setBackground(FavoriteCityIcon.getStarImage(1));
            FavoriteCityNode.isFavorite = false;
        }
    }

}
