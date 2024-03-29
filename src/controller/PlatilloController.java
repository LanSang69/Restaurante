package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import entities.Bebida;
import entities.Comida;
import entities.Postre;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class PlatilloController implements Initializable {

    private List<Comida> comidas = new ArrayList<>();
    private List<Bebida> bebidas = new ArrayList<>();
    private List<Postre> postres = new ArrayList<>();

    @FXML
    private TextArea descripcionP;

    @FXML
    private TextField nombreP;

    @FXML
    private TextField precioP;

    @FXML
    private Button submitB;

    @FXML
    private Label success;

    @FXML
    private ChoiceBox<String> tipoP;

    private String[] tipos = {"Comida", "Bebida", "Postre"};

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tipoP.getItems().addAll(tipos);
    }

    public String getSelectedTipo() {
        return tipoP.getValue();
    }

    public Button getSubmitButton() {
        return submitB;
    }

    // Getter and Setter for 'nombreP'
    public String getNombreP() {
        return nombreP.getText();
    }

    public void setNombreP(String nombre) {
        nombreP.setText(nombre);
    }

    // Getter and Setter for 'precioP'
    public String getPrecioP() {
        return precioP.getText();
    }

    public void setPrecioP(String precio) {
        precioP.setText(precio);
    }

    // Getter and Setter for 'descripcionP'
    public String getDescripcionP() {
        return descripcionP.getText();
    }

    public void setDescripcionP(String descripcion) {
        descripcionP.setText(descripcion);
    }

    @FXML
    public void addTolist(ActionEvent event) {
        String tipo_platillo = tipoP.getValue();

        // Validate that the required fields are not empty
        if (nombreP.getText().isEmpty() || precioP.getText().isEmpty()) {
            success.setTextFill(Color.RED);
            success.setText("Nombre y precio son obligatorios");
            return;
        }
    
        switch (tipo_platillo) {
            case "Comida":
                Comida nuevaComida = new Comida(nombreP.getText(), Double.parseDouble(precioP.getText()), descripcionP.getText());
    
                // Check if the comida already exists in the list
                if (!comidas.contains(nuevaComida)) {
                    comidas.add(nuevaComida);
                } else {
                    // Handle duplicate item (e.g., show a message)
                    success.setText("¡La comida ya existe!");
                }
                break;
            case "Bebida":
                Bebida nuevBebida = new Bebida(nombreP.getText(), Double.parseDouble(precioP.getText()), descripcionP.getText());
        
                // Check if the comida already exists in the list
                if (!bebidas.contains(nuevBebida)) {
                    bebidas.add(nuevBebida);
                } else {
                    // Handle duplicate item (e.g., show a message)
                    success.setText("¡La bebida ya existe!");
                }
                break;
            case "Postre":
                Postre nuevPostre = new Postre(nombreP.getText(), Double.parseDouble(precioP.getText()), descripcionP.getText());
    
            // Check if the comida already exists in the list
            if (!postres.contains(nuevPostre)) {
                postres.add(nuevPostre);
            } else {
                // Handle duplicate item (e.g., show a message)
                success.setText("¡La comida ya existe!");
            }
                break;
            default:
                throw new IllegalArgumentException("Invalid tipo value: " + tipo_platillo);
        }
    
            // Clear other fields and update UI
        success.setTextFill(Color.GREEN);
        success.setText("Añadido exitosamente");
        nombreP.setText("");
        precioP.setText("");
        descripcionP.setText("");

        // Introduce a delay before clearing the success message
        PauseTransition pause = new PauseTransition(Duration.seconds(1)); // You can adjust the duration as needed
        pause.setOnFinished(e -> {
            success.setText(""); // Clear the success message after the delay
        });
        pause.play();
    }
    

    // Getter for the 'comidas' list
    public List<Comida> getComidas() {
        return comidas;
    }

    // Getter for the 'bebidas' list
    public List<Bebida> getBebidas() {
        return bebidas;
    }

    // Getter for the 'postres' list
    public List<Postre> getPostres() {
        return postres;
    }
}
