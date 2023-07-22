package com.github.ericnaibert.weatherfx.favorite;

import com.github.ericnaibert.weatherfx.ApplicationInterface;
import com.github.ericnaibert.weatherfx.Main;
import com.github.ericnaibert.weatherfx.window.NodeStorage;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.IOException;
import java.util.Objects;

public class FavoriteCityNode extends ApplicationInterface {

    public static void favoriteButton(double locationX, double locationY) {

        Image starImage1;
        Image starImage2;
        try {
            starImage1 = new Image(Objects.requireNonNull(Main.class.getResource("images/Star1.png")).openStream());
            starImage2 = new Image(Objects.requireNonNull(Main.class.getResource("images/Star2.png")).openStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Button favoriteButton = new Button();
        favoriteButton.setLayoutX(locationX);
        favoriteButton.setLayoutY(locationY);
        favoriteButton.setBackground(new Background(new BackgroundImage(starImage1, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(28, 28,
                false, false, true, false))));
        favoriteButton.setPrefWidth(28);
        favoriteButton.setPrefHeight(28);
        NodeStorage.addToNodeStorageList(favoriteButton);
        root.getChildren().add(favoriteButton);

    }

}
