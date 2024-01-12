package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import java.io.IOException;
import javax.tools.JavaFileManager.Location;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class Controller {
    
        private Stage stage;
        private Scene scene;
        private Parent root;

    @FXML
    private Button close;

    @FXML
    private Button menuButton;

    @FXML
    private Button pedidoButton;

    @FXML
    private Button platilloButton;

    @FXML
    private Button repartidorButton;

    @FXML
    private Button restauranteB;

    public void displayMenu(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/resources/fxml/menu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void realizarPedido(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/resources/fxml/pedido.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void registrarPlatilllo(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/resources/fxml/platillo.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void registrarRepartidor(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/resources/fxml/repartidor.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void registrarRestaurante(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/resources/fxml/restaurante.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void salir(ActionEvent event) {
        Platform.exit();
    }

}
