package com.github.ericnaibert.weatherfx.data;

import com.github.ericnaibert.weatherfx.InputFieldEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

public class KeyInputFieldEvent implements InputFieldEvent {

    @Override
    public EventHandler<ActionEvent> eventHandler(TextField textField) {

        KeyStorage keyStorage = new KeyStorage();

        textField.setOnKeyPressed(event -> {

            if(event.getCode() == KeyCode.ENTER) {
                keyStorage.storeKey(textField.getText());
            }

        });

        return null;
    }


}
