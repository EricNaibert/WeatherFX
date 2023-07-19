package com.github.ericnaibert.weatherfx.data;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class KeyStorage {

    public void storeKey(String accessKey) {

        String userHome = System.getProperty("user.home");
        String path = userHome + File.separator + "WeatherFX" + File.separator + "WeatherConfig.wfx";

        try {
            Files.createDirectories(Path.of(userHome + File.separator + "WeatherFX"));

        } catch (IOException e) {
            System.out.println("Could not Create Directory! Exception: " + e);
        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);

            dataOutputStream.writeBytes(accessKey);
            dataOutputStream.close();

        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }

    }
}
