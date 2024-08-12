module uz.efood.app {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires kotlin.stdlib;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
  //  requires eu.hansolo.tilesfx;

    opens uz.efood.app to javafx.fxml;
    exports uz.efood.app;
    exports uz.efood.app.controller;

}