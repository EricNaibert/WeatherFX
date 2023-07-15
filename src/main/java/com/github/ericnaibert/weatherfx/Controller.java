package com.github.ericnaibert.weatherfx;

import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;

@SuppressWarnings("unused")
public class Controller {

    @FXML
    private Hyperlink ericNaibert;
    @FXML
    private Hyperlink weatherAPI;
    protected HostServices hostServices;

    public void setGetHostController(HostServices hostServices) {
        this.hostServices = hostServices;
    }

    public void hyperlinkGit(ActionEvent actionEvent) {
        hostServices.showDocument("https://github.com/EricNaibert");
    }

    public void hyperlinkAPI(ActionEvent actionEvent) {
        hostServices.showDocument("https://www.weatherapi.com");
    }
}