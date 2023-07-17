package com.github.ericnaibert.weatherfx.window;

import com.github.ericnaibert.weatherfx.Main;
import com.github.ericnaibert.weatherfx.api.WeatherData;
import javafx.scene.image.ImageView;

public class WindArrowDirection extends ApplicationInterface{

    public static void arrowDirection() {
        WeatherData weatherData = new WeatherData();
        String windDirection = weatherData.getCurrentWindDirection();

        ImageView cityWindDirectionImage = new ImageView(String.valueOf(Main.class.getResource("images/ArrowUP.png")));
        cityWindDirectionImage.setLayoutX(450);
        cityWindDirectionImage.setLayoutY(215);
        cityWindDirectionImage.setRotate(rotationValue(windDirection));
        ApplicationInterface.root.getChildren().add(cityWindDirectionImage);
        NodeStorage.addToNodeStorageList(cityWindDirectionImage);
    }

    private static double rotationValue(String windDirection) {

        return switch (windDirection) {
            case "NNE" -> 22.5;
            case "NE" -> 45;
            case "ENE" -> 67.5;
            case "E" -> 90;
            case "ESE" -> 112.5;
            case "SE" -> 135;
            case "SSE" -> 157.5;
            case "S" -> 180;
            case "SSW" -> 202.5;
            case "SW" -> 225;
            case "WSW" -> 247.5;
            case "W" -> 270;
            case "WNW" -> 292.5;
            case "NW" -> 315;
            case "NNW" -> 337.5;
            case "N" -> 360;

            default -> 0;
        };

    }
}
