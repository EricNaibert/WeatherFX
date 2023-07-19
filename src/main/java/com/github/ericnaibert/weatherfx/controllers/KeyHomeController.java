package com.github.ericnaibert.weatherfx.controllers;

import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;

public class KeyHomeController {

    @FXML
    private Hyperlink signUp;
    protected HostServices hostServices;

    public void setHostServices(HostServices hostServices) {
        this.hostServices = hostServices;
    }

    public void hyperlinkSignUp(ActionEvent actionEvent) {
        hostServices.showDocument("https://www.weatherapi.com/signup.aspx");
    }
}
