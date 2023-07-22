package com.github.ericnaibert.weatherfx.favorite;

import com.github.ericnaibert.weatherfx.Main;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.IOException;
import java.util.Objects;

public class FavoriteCityIcon {

    protected static Background getStarImage(int color) {
        Image starImage1;
        Image starImage2;

        try {
            starImage1 = new Image(Objects.requireNonNull(Main.class.getResource("images/Star1.png")).openStream());
            starImage2 = new Image(Objects.requireNonNull(Main.class.getResource("images/Star2.png")).openStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Background star1 = new Background((new BackgroundImage(starImage1, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(28, 28,
                false, false, true, false))));

        Background star2 = new Background((new BackgroundImage(starImage2, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(28, 28,
                false, false, true, false))));

        if (color == 1) {
            return star1;
        } else {
            return star2;
        }
    }

}
