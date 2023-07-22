package com.github.ericnaibert.weatherfx.api;

import com.github.ericnaibert.weatherfx.ApplicationInterface;
import com.github.ericnaibert.weatherfx.tools.LoadingProgressHud;
import com.github.ericnaibert.weatherfx.window.CurrentWeatherNodes;
import com.github.ericnaibert.weatherfx.window.ForecastWeatherNodes;
import com.github.ericnaibert.weatherfx.window.NodeStorage;

public class InvokeTask {

    public static void invokeWeatherTask(String cityName) {
        WeatherConnection weatherConnection = new WeatherConnection();
        weatherConnection.setCityName(cityName);
        Thread thread = new Thread(weatherConnection);
        thread.setDaemon(true);
        thread.start();

        weatherConnection.setOnRunning(event1 -> {
            LoadingProgressHud.progressLoadingHub();
            LoadingProgressHud.stage.show();
            ApplicationInterface.root.getChildren().removeAll(NodeStorage.getNodeStorageList());
        });

        weatherConnection.setOnSucceeded(event1 -> {
            LoadingProgressHud.stage.close();
            CurrentWeatherNodes.nodesToScreen();
            ForecastWeatherNodes.nodesToScreen();

        });
    }

}
