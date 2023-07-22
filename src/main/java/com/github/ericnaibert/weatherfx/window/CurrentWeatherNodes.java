package com.github.ericnaibert.weatherfx.window;

import com.github.ericnaibert.weatherfx.ApplicationInterface;
import com.github.ericnaibert.weatherfx.api.WeatherData;
import com.github.ericnaibert.weatherfx.favorite.FavoriteCityNode;
import javafx.scene.control.Label;

public class CurrentWeatherNodes extends ApplicationInterface {

    public static void nodesToScreen() {

        WeatherData weatherData = new WeatherData();
        int defaultLayoutX = 40;

        Label cityNameResult = new Label();
        cityNameResult.setText(weatherData.getCurrentCityName());
        cityNameResult.setId("cityID");
        cityNameResult.setLayoutX(defaultLayoutX);
        cityNameResult.setLayoutY(85);
        root.getChildren().add(cityNameResult);
        NodeStorage.addToNodeStorageList(cityNameResult);

        double cityNameLength = cityNameResult.getText().getBytes().length;
        double finalLength;
        if(cityNameLength <= 10) {
            finalLength = 20 * cityNameLength;
        } else {
            finalLength = 17 * cityNameLength;
        }

        FavoriteCityNode.favoriteButton(defaultLayoutX + finalLength, 88);

        Label cityRegionResult = new Label();
        cityRegionResult.setText(weatherData.getCurrentRegion() + ", " + weatherData.getCurrentCountry());
        cityRegionResult.setId("infoResultID");
        cityRegionResult.setLayoutX(defaultLayoutX);
        cityRegionResult.setLayoutY(120);
        root.getChildren().add(cityRegionResult);
        NodeStorage.addToNodeStorageList(cityRegionResult);

        Label cityCurrentTemperatureResult = new Label();
        cityCurrentTemperatureResult.setText(weatherData.getCurrentTemperatureC() + "°C | " + weatherData.getCurrentTemperatureF() + "°F");
        cityCurrentTemperatureResult.setId("currentTemperatureID");
        cityCurrentTemperatureResult.setLayoutX(defaultLayoutX);
        cityCurrentTemperatureResult.setLayoutY(170);
        cityCurrentTemperatureResult.setTextFill(Gradients.getGradient1());
        root.getChildren().add(cityCurrentTemperatureResult);
        NodeStorage.addToNodeStorageList(cityCurrentTemperatureResult);

        Label cityFeelsLikeResult = new Label();
        cityFeelsLikeResult.setText("Feels like " + weatherData.getCurrentFeelsLikeC() + "°C | " + weatherData.getCurrentFeelsLikeF() + "°F");
        cityFeelsLikeResult.setId("feelsLikeID");
        cityFeelsLikeResult.setLayoutX(defaultLayoutX);
        cityFeelsLikeResult.setLayoutY(212);
        cityFeelsLikeResult.setTextFill(Gradients.getGradient2());
        root.getChildren().add(cityFeelsLikeResult);
        NodeStorage.addToNodeStorageList(cityFeelsLikeResult);

        Label cityHumidityResult = new Label();
        cityHumidityResult.setText("Humidity " + weatherData.getCurrentCityHumidity());
        cityHumidityResult.setId("infoResultID");
        cityHumidityResult.setLayoutX(defaultLayoutX);
        cityHumidityResult.setLayoutY(240);
        root.getChildren().add(cityHumidityResult);
        NodeStorage.addToNodeStorageList(cityHumidityResult);

        Label cityWindSpeedResult = new Label();
        cityWindSpeedResult.setText(weatherData.getCurrentWindSpeed() + "km/h");
        cityWindSpeedResult.setId("windSpeedID");
        cityWindSpeedResult.setLayoutX(370);
        cityWindSpeedResult.setLayoutY(172);
        root.getChildren().add(cityWindSpeedResult);
        NodeStorage.addToNodeStorageList(cityWindSpeedResult);

        Label cityWindDirectionResult = new Label();
        cityWindDirectionResult.setText("  " + weatherData.getCurrentWindDirection());
        cityWindDirectionResult.setId("windDirectionID");
        cityWindDirectionResult.setLayoutX(380);
        cityWindDirectionResult.setLayoutY(210);
        root.getChildren().add(cityWindDirectionResult);
        NodeStorage.addToNodeStorageList(cityWindDirectionResult);

        WindArrowDirection.arrowDirection();

        Label cityWindLabel = new Label();
        cityWindLabel.setText("Wind");
        cityWindLabel.setId("infoResultID");
        cityWindLabel.setLayoutX(380);
        cityWindLabel.setLayoutY(235);
        root.getChildren().add(cityWindLabel);
        NodeStorage.addToNodeStorageList(cityWindLabel);

        Label cityUVResult = new Label();
        cityUVResult.setText(String.valueOf(weatherData.getCurrentCityUV()));
        cityUVResult.setId("windSpeedID");
        cityUVResult.setLayoutX(570);
        cityUVResult.setLayoutY(172);
        root.getChildren().add(cityUVResult);
        NodeStorage.addToNodeStorageList(cityUVResult);

        Label cityUVR = new Label();
        cityUVR.setText("UVR");
        cityUVR.setId("infoResultID");
        cityUVR.setLayoutX(575);
        cityUVR.setLayoutY(235);
        root.getChildren().add(cityUVR);
        NodeStorage.addToNodeStorageList(cityUVR);

        UVColorLevel.uvColorChanger();

    }

}
