package com.github.ericnaibert.weatherfx.data;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class KeyReader {

    private static String accessKey;

    private static void keyReader() {

        byte[] fileBytes;
        String userHome = System.getProperty("user.home");
        File path = new File(userHome + File.separator + "WeatherFX" + File.separator + "WeatherConfig.wfx");

        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);

            fileBytes = dataInputStream.readAllBytes();
            accessKey = new String(fileBytes, StandardCharsets.UTF_8);

        } catch(FileNotFoundException e) {
            System.out.println("Key Reader(): File Not Found! Exception: " + e);
        } catch (IOException e) {
            System.out.println("Key Reader(): Cannot Read File! Exception: " + e);
        }
    }

    public static String getAccessKey() {
        keyReader();
        return accessKey;
    }
}
