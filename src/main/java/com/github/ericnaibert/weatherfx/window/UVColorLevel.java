package com.github.ericnaibert.weatherfx.window;

import com.github.ericnaibert.weatherfx.Main;
import com.github.ericnaibert.weatherfx.api.WeatherData;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class UVColorLevel extends ApplicationInterface{

    public static void uvColorChanger() {

        WeatherData weatherData = new WeatherData();

        double uvLevel = weatherData.getCurrentCityUV();
        Image colorGreen = new Image(String.valueOf(Main.class.getResource("images/UVGreen.png")));
        Image colorYellow = new Image(String.valueOf(Main.class.getResource("images/UVYellow.png")));
        Image colorOrange = new Image(String.valueOf(Main.class.getResource("images/UVOrange.png")));
        Image colorRed = new Image(String.valueOf(Main.class.getResource("images/UVRed.png")));
        Image colorExtreme = new Image(String.valueOf(Main.class.getResource("images/UVExtreme.png")));

        ImageView cityUVRLevel = new ImageView(colorGreen);
        cityUVRLevel.setLayoutX(580);
        cityUVRLevel.setLayoutY(205);

        if(uvLevel <= 2) {
            cityUVRLevel.setImage(colorGreen);
        } else if(uvLevel >= 3 && uvLevel <= 5) {
            cityUVRLevel.setImage(colorYellow);
        } else if(uvLevel >= 6 && uvLevel <= 7){
            cityUVRLevel.setImage(colorOrange);
        } else if (uvLevel >= 8 && uvLevel <= 10) {
            cityUVRLevel.setImage(colorRed);
        } else {
            cityUVRLevel.setImage(colorExtreme);
        }

        cityUVRLevel.setFitHeight(30);
        cityUVRLevel.setFitWidth(30);
        root.getChildren().add(cityUVRLevel);
        NodeStorage.addToNodeStorageList(cityUVRLevel);
    }

}
