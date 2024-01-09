package controller;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Controller {
    
    public Button menu;

    @FXML
    private void show_menu(ActionEvent event) {
        menu.setText("Pressed");
    }

    @FXML
    private void r_pedido(ActionEvent event) {
        // Code to handle the "Realizar un pedido" button click
    }

    @FXML
    private void r_repartidores(ActionEvent event) {
        // Code to handle the "Registrar repartidores" button click
    }

    @FXML
    private void r_platillo(ActionEvent event) {
        // Code to handle the "Registrar platillo" button click
    }

    @FXML
    private void r_datos_restaurante(ActionEvent event) {
        // Code to handle the "Registrar datos del restaurante" button click
    }

    @FXML
    private void close(ActionEvent event) {
        Platform.exit();
    }
}
