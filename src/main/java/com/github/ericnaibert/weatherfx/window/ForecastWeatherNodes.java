package com.github.ericnaibert.weatherfx.window;

import com.github.ericnaibert.weatherfx.ApplicationInterface;
import com.github.ericnaibert.weatherfx.tools.DateDefinition;
import com.github.ericnaibert.weatherfx.api.WeatherData;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class ForecastWeatherNodes extends ApplicationInterface {

    public static void nodesToScreen() {

        ArrayList<Label> forecastDateResult = new ArrayList<>();
        ArrayList<Label> forecastWeatherTextResult = new ArrayList<>();
        ArrayList<ImageView> forecastWeatherIconResult = new ArrayList<>();
        ArrayList<Label> maxTemperatureResult = new ArrayList<>();
        ArrayList<Label> minTemperatureResult = new ArrayList<>();
        ArrayList<Label> forecastHumidityResult = new ArrayList<>();

        int posX = 90;
        int posY = 290;

        WeatherData weatherData = new WeatherData();

        VBox forecastVBox1 = new VBox();
        forecastVBox1.setPrefWidth(150);
        forecastVBox1.setLayoutX(posX);
        forecastVBox1.setLayoutY(posY);
        forecastVBox1.setAlignment(Pos.CENTER);

        VBox forecastVBox2 = new VBox();
        forecastVBox2.setPrefWidth(150);
        forecastVBox2.setLayoutX(posX * 3);
        forecastVBox2.setLayoutY(posY);
        forecastVBox2.setAlignment(Pos.CENTER);

        VBox forecastVBox3 = new VBox();
        forecastVBox3.setPrefWidth(150);
        forecastVBox3.setLayoutX(posX * 5);
        forecastVBox3.setLayoutY(posY);
        forecastVBox3.setAlignment(Pos.CENTER);

        DateDefinition.currentDate();
        forecastDateResult.add(0, new Label("Today"));
        forecastVBox1.getChildren().add(forecastDateResult.get(0));
        forecastDateResult.add(1, new Label(DateDefinition.tomorrowDate));
        forecastVBox2.getChildren().add(forecastDateResult.get(1));
        forecastDateResult.add(2, new Label(DateDefinition.afterTomorrowDate));
        forecastVBox3.getChildren().add(forecastDateResult.get(2));

        forecastWeatherIconResult.add(0, new ImageView());
        forecastVBox1.getChildren().add(forecastWeatherIconResult.get(0));
        forecastWeatherIconResult.add(1, new ImageView());
        forecastVBox2.getChildren().add(forecastWeatherIconResult.get(1));
        forecastWeatherIconResult.add(2, new ImageView());
        forecastVBox3.getChildren().add(forecastWeatherIconResult.get(2));

        forecastWeatherTextResult.add(0, new Label(splitIfBig(weatherData.getForecastCityWeatherText(0))));
        forecastVBox1.getChildren().add(forecastWeatherTextResult.get(0));
        forecastWeatherTextResult.add(1, new Label(splitIfBig(weatherData.getForecastCityWeatherText(1))));
        forecastVBox2.getChildren().add(forecastWeatherTextResult.get(1));
        forecastWeatherTextResult.add(2, new Label(splitIfBig(weatherData.getForecastCityWeatherText(2))));
        forecastVBox3.getChildren().add(forecastWeatherTextResult.get(2));

        String temperatureSeparator = "°C | ";

        maxTemperatureResult.add(0, new Label(weatherData.getMaxTemperatureC(0) + temperatureSeparator +
                weatherData.getMaxTemperatureF(0) + "°F"));
        forecastVBox1.getChildren().add(maxTemperatureResult.get(0));

        maxTemperatureResult.add(1, new Label(weatherData.getMaxTemperatureC(0) + temperatureSeparator +
                weatherData.getMaxTemperatureF(1) + "°F"));
        forecastVBox2.getChildren().add(maxTemperatureResult.get(1));

        maxTemperatureResult.add(2, new Label(weatherData.getMaxTemperatureC(0) + temperatureSeparator +
                weatherData.getMaxTemperatureF(2) + "°F"));
        forecastVBox3.getChildren().add(maxTemperatureResult.get(2));


        minTemperatureResult.add(0, new Label(weatherData.getMinTemperatureC(0) + temperatureSeparator +
                weatherData.getMinTemperatureF(0) + "°F"));
        forecastVBox1.getChildren().add(minTemperatureResult.get(0));

        minTemperatureResult.add(1, new Label(weatherData.getMinTemperatureC(1) + temperatureSeparator +
                weatherData.getMinTemperatureF(0) + "°F"));
        forecastVBox2.getChildren().add(minTemperatureResult.get(1));

        minTemperatureResult.add(2, new Label(weatherData.getMinTemperatureC(2) + temperatureSeparator +
                weatherData.getMinTemperatureF(0) + "°F"));
        forecastVBox3.getChildren().add(minTemperatureResult.get(2));

        forecastHumidityResult.add(0, new Label(weatherData.getDayPrecipitation(0) + "mm"));
        forecastVBox1.getChildren().add(forecastHumidityResult.get(0));
        forecastHumidityResult.add(1, new Label(weatherData.getDayPrecipitation(1) + "mm"));
        forecastVBox2.getChildren().add(forecastHumidityResult.get(1));
        forecastHumidityResult.add(2, new Label(weatherData.getDayPrecipitation(2) + "mm"));
        forecastVBox3.getChildren().add(forecastHumidityResult.get(2));


        root.getChildren().add(forecastVBox1);
        root.getChildren().add(forecastVBox2);
        root.getChildren().add(forecastVBox3);


        for (int i = 0; i <= 2; i++) {
            forecastDateResult.get(i).setId("dayOfWeekID");

            forecastWeatherIconResult.get(i).setImage(new Image("https:" + weatherData.getForecastCityWeatherIcon(i)));

            forecastWeatherTextResult.get(i).setId("forecastInfoResultID");

            maxTemperatureResult.get(i).setId("forecastInfoResultID");

            minTemperatureResult.get(i).setId("forecastInfoResultID");

            forecastHumidityResult.get(i).setId("forecastInfoResultID");
        }

        NodeStorage.addToNodeStorageList(forecastVBox1);
        NodeStorage.addToNodeStorageList(forecastVBox2);
        NodeStorage.addToNodeStorageList(forecastVBox3);
    }

    public static String splitIfBig(String weatherText) {

        String[] weatherTextArray = weatherText.split(" ");
        if(weatherTextArray.length > 2) {
            return "    " + weatherTextArray[0] + "\n" + weatherTextArray[1] + " " + weatherTextArray[2];
        } else {
            return weatherText;
        }
    }
}
