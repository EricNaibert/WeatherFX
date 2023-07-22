package com.github.ericnaibert.weatherfx.data;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class KeyHomeAlert extends Stage {

    public void isKeyValid(boolean successful) {

        if(successful) {
            alertMessage("Key Successful Saved. Restart the Application!");
        } else {
            alertMessage("Invalid Key. Please, enter a valid one!");
        }
    }

    private void alertMessage(String message) {

        Stage stage = new Stage();

        Group alertRoot = new Group();

        Label label = new Label();
        label.setText(message);
        label.setFont(new Font("Arial", 17));
        label.setStyle("-fx-font-weight: bold;");
        label.setPrefWidth(390);
        label.setAlignment(Pos.CENTER);

        VBox vBox = new VBox();
        vBox.setLayoutY(40);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().add(label);

        alertRoot.getChildren().add(vBox);

        Scene alertScene = new Scene(alertRoot, 400, 100);

        stage.setTitle("Message");
        stage.requestFocus();
        stage.setResizable(false);
        stage.alwaysOnTopProperty();
        stage.setScene(alertScene);
        stage.show();
    }

}
