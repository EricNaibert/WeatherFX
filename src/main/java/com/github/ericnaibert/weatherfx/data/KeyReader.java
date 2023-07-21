package com.github.ericnaibert.weatherfx.data;

import java.io.*;

public class KeyReader {

    private static String accessKey;

    public static void keyReader() {

        String userHome = System.getProperty("user.home");
        String path = userHome + File.separator + "WeatherFX" + File.separator + "WeatherConfig.wfx";

        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);

            setAccessKey(dataInputStream.readUTF());

        } catch(FileNotFoundException e) {
            System.out.println("Key Reader(): File Not Found! Exception: " + e);
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }

    public static String getAccessKey() {
        keyReader();
        return accessKey;
    }

    private static void setAccessKey(String accessKey) {
        KeyReader.accessKey = accessKey;
    }
}
