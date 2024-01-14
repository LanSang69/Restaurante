package controller;

import java.io.IOException;
import java.util.List;

import entities.Bebida;
import entities.Comida;
import entities.Postre;
import entities.Restaurante;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class Menu2Controller{

    private Parent root;

    @FXML
    private AnchorPane centerPane;

    @FXML
    private ImageView salirB;

    private Restaurante restaurante = new Restaurante();  // Assume you have an instance of Restaurante
    private Comida comida;
    private Bebida bebida;
    private Postre postre;
    
    @FXML
    private void initialize() {
        // Load the initial content
        loadInitialContent();
    }
    
    
    @FXML
    private void handleVerMenu() throws IOException {    
        // Get the updated list of Comida from the Restaurante
        List<Comida> comidaList = restaurante.getComidas();
        System.out.println("Menu: " + comidaList);
    
        // Convert the list to ObservableList if needed
        ObservableList<Comida> newData = FXCollections.observableArrayList(comidaList);
    
        // Load the content for "Ver menu" and pass the MenuController instance
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/menu.fxml"));
        root = loader.load();
    
        MenuController menuController = loader.getController();
        menuController.updateList(newData);
    
        loadMenu(root);
    }
    


    @FXML
    private void handleRestaurante() {
        loadContent("/resources/fxml/restaurante.fxml");
    }

    @FXML
    private void handlePlatillo() throws IOException {
        // Load the content for "Ver menu" and pass the MenuController instance
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/platillo.fxml"));
        root = loader.load();
    
        PlatilloController platilloController = loader.getController();
        Button submitButton = platilloController.getSubmitButton();
        // Add an event listener to the button
        submitButton.setOnAction(event -> {
            // Your event handling code here
            System.out.println("Submit button clicked!");
            platilloController.addTolist(event);
    
            // Get the list of Comida from PlatilloController
            List<Comida> comidasToAdd = platilloController.getComidas();
    
            // Add each Comida to the restaurante using agregarComida method
            for (Comida comida : comidasToAdd) {
                restaurante.agregarComida(comida);
            }
    
            // Print the updated list in restaurante (optional)
            System.out.println("Comidas in Restaurante: " + restaurante.getComidas());
    
            loadMenu(root);
        });
    
        // Load the content (assuming this is the rest of your method)
        loadMenu(root);
    }
    

    @FXML
    private void handleRepartidor() {
        // Load the content for "Agregar pedido"
        loadContent("/resources/fxml/repartidor.fxml");
    }

    private void loadInitialContent() {
        // Load the initial content (you can change this as needed)
        loadContent("/resources/fxml/initialContent.fxml");
    }

    private void loadContent(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent content = loader.load();

            // Set the loaded content as the children of the centerPane
            centerPane.getChildren().setAll(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadMenu(Parent content) {
        // Set the loaded content as the children of the centerPane
        centerPane.getChildren().setAll(content);
    }
    

    @FXML
    void close(MouseEvent event) {
        // Close the application (you can customize this based on your needs)
        System.exit(0);
    }

}
