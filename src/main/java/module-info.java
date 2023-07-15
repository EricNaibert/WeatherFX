module com.github.ericnaibert.weatherfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.google.gson;

    opens com.github.ericnaibert.weatherfx to javafx.fxml, com.google.gson;
    exports com.github.ericnaibert.weatherfx;
}