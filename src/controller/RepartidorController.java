package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class RepartidorController implements Initializable {

    @FXML
    private TextField DireccionR;

    @FXML
    private Label success;


    @FXML
    private TextField apellidoR;

    @FXML
    private ChoiceBox<String> medio;

    @FXML
    private TextField nombreR;

    @FXML
    private Button submitR;

    @FXML
    private TextField telefonoR;

    private String[] medios = {"Motocicleta", "Bicicleta"};

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        medio.getItems().addAll(medios);
    }

    public TextField getDireccionR() {
        return DireccionR;
    }

    public void setDireccionR(String direccionText) {
        this.DireccionR.setText(direccionText);
    }

    public Label getSuccess(){
        return this.success;
    }

    public void setSucccess(String text){
        success.setText(text);
    }

    public TextField getApellidoR() {
        return apellidoR;
    }

    public void setApellidoR(String apellidoText) {
        this.apellidoR.setText(apellidoText);
    }

    public ChoiceBox<String> getMedio() {
        return medio;
    }

    // No setter for ChoiceBox, as you typically modify the items directly instead

    public TextField getNombreR() {
        return nombreR;
    }

    public void setNombreR(String nombreText) {
        this.nombreR.setText(nombreText);
    }

    public Button getSubmitR() {
        return submitR;
    }

    public void setSubmitR(Button submitButton) {
        this.submitR = submitButton;
    }

    public TextField getTelefonoR() {
        return telefonoR;
    }

    public void setTelefonoR(String telefonoText) {
        this.telefonoR.setText(telefonoText);
    }
}
