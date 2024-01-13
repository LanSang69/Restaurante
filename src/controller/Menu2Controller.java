package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class Menu2Controller {

    @FXML
    private AnchorPane centerPane;

    @FXML
    private ImageView salirB;

    @FXML
    private void initialize() {
        // Load the initial content
        loadInitialContent();
    }

    @FXML
    private void handleVerMenu() {
        // Load the content for "Ver menu"
        loadContent("/resources/fxml/menu.fxml");
    }

    @FXML
    private void handleAgregarPedido() {
        // Load the content for "Agregar pedido"
        loadContent("/resources/fxml/agregarPedido.fxml");
    }

    // Add similar methods for other buttons...

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

    @FXML
    void close(MouseEvent event) {
        // Close the application (you can customize this based on your needs)
        System.exit(0);
    }

}
