package com.github.ericnaibert.weatherfx.data;

import java.io.*;

public class KeyReader {

    private static String accessKey;

    public static void keyReader() {

        String path = "";

        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);

            setAccessKey(dataInputStream.readUTF());

        } catch(FileNotFoundException e) {
            System.out.println("File Not Found! Exception: " + e);
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
