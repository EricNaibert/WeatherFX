package com.github.ericnaibert.weatherfx.favorite;

import com.github.ericnaibert.weatherfx.ApplicationInterface;
import com.github.ericnaibert.weatherfx.window.NodeStorage;
import javafx.scene.control.Button;

public class FavoriteCityNode extends ApplicationInterface {

    protected static boolean isFavorite = false;

    public static void favoriteButton(double locationX, double locationY) {

        Button favoriteButton = new Button();
        favoriteButton.setLayoutX(locationX);
        favoriteButton.setLayoutY(locationY);
        favoriteButton.setBackground(FavoriteCityIcon.getStarImage(1));
        favoriteButton.setPrefWidth(28);
        favoriteButton.setPrefHeight(28);

        favoriteButton.setOnMouseClicked(event -> FavoriteCityEventHandler.event(favoriteButton));

        NodeStorage.addToNodeStorageList(favoriteButton);
        root.getChildren().add(favoriteButton);
    }
}