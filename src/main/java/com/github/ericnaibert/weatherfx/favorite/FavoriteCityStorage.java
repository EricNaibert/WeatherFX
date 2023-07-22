package com.github.ericnaibert.weatherfx.favorite;

import com.github.ericnaibert.weatherfx.tools.StoragePath;

import java.io.File;

public class FavoriteCityStorage {

    public static void storeFavorite() {

        StoragePath storagePath = new StoragePath();
        File file = storagePath.favoritePath();
    }

}
