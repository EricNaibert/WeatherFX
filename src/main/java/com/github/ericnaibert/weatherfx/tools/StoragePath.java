package com.github.ericnaibert.weatherfx.tools;

import java.io.File;

public class StoragePath {

    public File keyPath() {
        String userHome = System.getProperty("user.home");
        String path = userHome + File.separator + "WeatherFX" + File.separator + "WeatherConfig.wfx";
        return new File(path);
    }

    public File favoritePath() {
        String userHome = System.getProperty("user.home");
        String path = userHome + File.separator + "WeatherFX" + File.separator + "FavoriteCity.wfx";
        return new File(path);
    }

}
