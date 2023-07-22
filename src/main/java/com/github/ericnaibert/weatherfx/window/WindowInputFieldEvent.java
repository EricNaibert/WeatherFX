package com.github.ericnaibert.weatherfx.window;

import com.github.ericnaibert.weatherfx.ApplicationInterface;
import com.github.ericnaibert.weatherfx.InputFieldEvent;
import com.github.ericnaibert.weatherfx.api.InvokeTask;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

import java.text.Normalizer;
import java.util.Arrays;

public class WindowInputFieldEvent implements InputFieldEvent {

    public static String inputCityName;

    @Override
    public EventHandler<ActionEvent> eventHandler(TextField textField) {

        textField.setOnKeyPressed(event -> {

            if (event.getCode() == KeyCode.ENTER) {

                String temp = textField.getText();
                String[] storeName = temp.split(" ");
                inputCityName = inputFilter(removeWhitespaces(storeName));

                InvokeTask.invokeWeatherTask(inputCityName);

                ApplicationInterface.inputField.clear();
                ApplicationInterface.inputField.requestFocus();

            }
        });
        return null;
    }

    public static String inputFilter(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }

    public static String removeWhitespaces(String[] array) {
        String rawString;

        if(array.length == 2) {
            rawString = array[0] + "_" + array[1];
        } else if(array.length == 3) {
            rawString = array[0] + "_" + array[1] + "_" + array[2];
        } else if(array.length >= 4) {
            rawString = array[0] + "_" + array[1] + "_" + array[2] + "_" + array[3];
        } else {
            rawString = Arrays.toString(array);
        }

        return rawString;
    }
}
