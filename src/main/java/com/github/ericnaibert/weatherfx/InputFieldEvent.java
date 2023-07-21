package com.github.ericnaibert.weatherfx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

@FunctionalInterface
public interface InputFieldEvent {

    EventHandler<ActionEvent> eventHandler(TextField textField);

}
