package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RestauranteController {

    @FXML
    private TextField direccionR;

    @FXML
    private TextField nombreR;

    @FXML
    private Button submitBR;

    @FXML
    private TextField telefonoR;

     @FXML
    private Label success;

    public Label getSuccess(){
        return success;
    }

    public void setSuccess(String success){
        this.success.setText(success);
    }

    public TextField getDireccionR() {
        return direccionR;
    }

    public void setDireccionR(TextField direccionR) {
        this.direccionR = direccionR;
    }

    public TextField getNombreR() {
        return nombreR;
    }

    public void setNombreR(TextField nombreR) {
        this.nombreR = nombreR;
    }

    public Button getSubmitBR() {
        return submitBR;
    }

    public void setSubmitBR(Button submitBR) {
        this.submitBR = submitBR;
    }

    public TextField getTelefonoR() {
        return telefonoR;
    }

    public void setTelefonoR(TextField telefonoR) {
        this.telefonoR = telefonoR;
    }
}
