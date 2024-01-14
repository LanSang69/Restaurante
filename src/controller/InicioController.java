package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class InicioController {

    @FXML
    private Label direccionR;

    @FXML
    private Label nombreRestaurante;

    @FXML
    private Label telefonoR;

    public Label getDireccionR() {
        return direccionR;
    }

    public void setDireccionR(String direccionR) {
        this.direccionR.setText(direccionR);
    }

    public Label getNombreRestaurante() {
        return nombreRestaurante;
    }

    public void setNombreRestaurante(String nombreRestaurante) {
        this.nombreRestaurante.setText(nombreRestaurante);
    }

    public Label getTelefonoR() {
        return telefonoR;
    }

    public void setTelefonoR(String telefonoR) {
        this.telefonoR.setText(telefonoR);
    }
}
