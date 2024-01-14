package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;
import entities.Bebida;
import entities.Cliente;
import entities.Comida;
import entities.Pedido;
import entities.Postre;
import entities.Receta;
import entities.Repartidor;
import entities.Restaurante;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

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
        List<Bebida> bebidaList = restaurante.getBebidas();
        List<Postre> postreList = restaurante.getPostres();
    
        // Convert the list to ObservableList if needed
        ObservableList<Comida> newDataC = FXCollections.observableArrayList(comidaList);
        ObservableList<Bebida> newDataB = FXCollections.observableArrayList(bebidaList);
        ObservableList<Postre> newDataP = FXCollections.observableArrayList(postreList);
    
        // Load the content for "Ver menu" and pass the MenuController instance
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/menu.fxml"));
        root = loader.load();
    
        MenuController menuController = loader.getController();
        menuController.updateList(newDataC);
        menuController.updateListB(newDataB);
        menuController.updateListP(newDataP);
    
        loadMenu(root);
    }

    @FXML
    private void handleRestaurante() throws IOException {
        // Load the content for "Ver menu" and pass the MenuController instance
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/restaurante.fxml"));
        root = loader.load();

        RestauranteController restauranteController = loader.getController();
        Button submitBR = restauranteController.getSubmitBR();
        Label successR = restauranteController.getSuccess();

        submitBR.setOnAction(e->{
            TextField nombreR = restauranteController.getNombreR();
            TextField telefonoR = restauranteController.getTelefonoR();
            TextField direccionR = restauranteController.getDireccionR();

            restaurante.setNombre(nombreR.getText());
            restaurante.setTelefono(telefonoR.getText());
            restaurante.setDireccion(direccionR.getText());

            successR.setTextFill(Color.GREEN);
            successR.setText("Añadido exitosamente");
            nombreR.setText("");
            telefonoR.setText("");
            direccionR.setText("");

        // Introduce a delay before clearing the success message
        PauseTransition pause = new PauseTransition(Duration.seconds(1)); // You can adjust the duration as needed
        pause.setOnFinished(f -> {
            successR.setText(""); // Clear the success message after the delay
        });
        pause.play();
        });

        loadMenu(root);
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
            platilloController.addTolist(event);

            // Get the list of Comida from PlatilloController
            List<Comida> comidasToAdd = platilloController.getComidas();
            List<Bebida> bebidasToAdd = platilloController.getBebidas();
            List<Postre> postresToAdd = platilloController.getPostres();
            
                    // Add each Comida to the restaurante using agregarComida method
                    for (Comida comida : comidasToAdd) {
                        restaurante.agregarComida(comida);
                    }
                    for (Bebida bebida : bebidasToAdd) {
                        restaurante.agregarBebida(bebida);
                    }
                    for (Postre postre : postresToAdd) {
                        restaurante.agregarPostre(postre);
                    }
        });
        
        // Load the content (assuming this is the rest of your method)
        loadMenu(root);
    }
    

    @FXML
    private void handleRepartidor() throws IOException{
        // Load the content for "Ver menu" and pass the MenuController instance
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/repartidor.fxml"));
        root = loader.load();

        RepartidorController repartidorController = loader.getController();
        Button submitRepartidor = repartidorController.getSubmitR();
        Label successR = repartidorController.getSuccess();

        submitRepartidor.setOnAction(e->{
            TextField nombres = repartidorController.getNombreR();
            TextField apellidos = repartidorController.getApellidoR();
            TextField direccion = repartidorController.getDireccionR();
            TextField telefono = repartidorController.getTelefonoR();
            String medio = repartidorController.getMedio().getValue();

            //I create a axiliar repartidor oject to insert it in restaurante
            Repartidor aux = new Repartidor(nombres.getText(), apellidos.getText(), direccion.getText(), telefono.getText(), medio);
            restaurante.agregarRepartidor(aux);

            //Sucees message
            successR.setTextFill(Color.GREEN);
            successR.setText("Añadido exitosamente");
            nombres.setText("");
            apellidos.setText("");
            direccion.setText("");
            telefono.setText("");

        // Introduce a delay before clearing the success message
        PauseTransition pause = new PauseTransition(Duration.seconds(1)); // You can adjust the duration as needed
        pause.setOnFinished(f -> {
            successR.setText(""); // Clear the success message after the delay
        });
        pause.play();

        });

        loadMenu(root);
    }
   
    @FXML
    private void handlePedido() throws IOException {
        ObservableList<Receta> recetas = FXCollections.observableArrayList();
    
        // Load the content for "Ver menu" and pass the MenuController instance
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/pedido.fxml"));
        root = loader.load();
    
        PedidoController pedidoController = loader.getController();
        Button agregar = pedidoController.getAgregar();
        TextField total = pedidoController.getTotal();
        total.setText("0");
    
        agregar.setOnAction(e -> {
            Double totalP = Double.parseDouble(total.getText());
            String nombrePlatillo = pedidoController.getNombreP().getText();
            Receta receta = null;
    
            if ((receta = restaurante.comidaEnReseta(nombrePlatillo)) != null) {
                recetas.add(receta);
            } else if ((receta = restaurante.bebidaEnReceta(nombrePlatillo)) != null) {
                recetas.add(receta);
            } else if ((receta = restaurante.postreEnReceta(nombrePlatillo)) != null) {
                recetas.add(receta);
            }
            pedidoController.updateList(recetas);
            pedidoController.getNombreP().setText("");
        });

        Button terminarC = pedidoController.getTerminarC();
        terminarC.setOnAction(e->{
            String id = RandomIdGenerator.generateRandomId(8);
            Cliente clienteAux = new Cliente(pedidoController.getNombreC().getText(), 
            pedidoController.getDireccionC().getText(), pedidoController.getTelC().getText(), 
            pedidoController.getSelection());

            Pedido pedidoAux = new Pedido(
                id,
                LocalDate.now(),
                LocalTime.now(),
                Double.parseDouble(pedidoController.getTotal().getText()),
                clienteAux,
                getRandomRepartidor(restaurante.getRepartidores()),
                restaurante.getComidas(),
                restaurante.getBebidas(),
                restaurante.getPostres()
            );

            restaurante.agregarPedido(pedidoAux);
            pedidoController.getNombreC().setText("");
            pedidoController.getTelC().setText("");
            pedidoController.getDireccionC().setText("");
            pedidoController.getNombreP().setText("");
            pedidoController.getTotal().setText("");
            pedidoController.setSuccess("Pedido realizado correctamente");
            pedidoController.getSuccess().setTextFill(Color.GREEN);
            // Clear the recetas list
            pedidoController.clear();

            // Introduce a delay before clearing the success message
            PauseTransition pause = new PauseTransition(Duration.seconds(1)); // You can adjust the duration as needed
            pause.setOnFinished(f -> {
                pedidoController.setSuccess("");; // Clear the success message after the delay
            });
            pause.play();

        });
        

        loadMenu(root);
    }
    

    private void loadInitialContent() {
        // Load the initial content (you can change this as needed)
        loadContent("/resources/fxml/inicio.fxml");
    }

    private void loadContent(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent content = loader.load();
    
            // Set the loaded content as the children of the centerPane
            centerPane.getChildren().setAll(content);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Failed to load FXML: " + fxmlPath);
        }
    }
    
     @FXML
    void viewRepartidores(ActionEvent event) throws IOException{
        List<Repartidor> repartidores = restaurante.getRepartidores();
        ObservableList<Repartidor> repartidoresOb = FXCollections.observableArrayList(repartidores);

        // Load the content for "Ver menu" and pass the MenuController instance
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/showRepartidores.fxml"));
        root = loader.load();

        ViewRepartidores viewRepartidores = loader.getController();
        viewRepartidores.updateList(repartidoresOb);

        loadMenu(root);
    }

    @FXML
    void viewPedidos(ActionEvent event) throws IOException{
        List<Pedido> pedidos = restaurante.getPedidos();
        ObservableList<Pedido> pedidosOb = FXCollections.observableArrayList(pedidos);

        // Load the content for "Ver menu" and pass the MenuController instance
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/showPedidos.fxml"));
        root = loader.load();

        showPedidos showPedidos = loader.getController();
        showPedidos.updateList(pedidosOb);

        loadMenu(root);
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

    @FXML
    void home(MouseEvent event) throws IOException{
         // Load the content for "Ver menu" and pass the MenuController instance
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/inicio.fxml"));
         root = loader.load();
 
         InicioController inicioController = loader.getController();
         inicioController.setNombreRestaurante(restaurante.getNombre());
         inicioController.setDireccionR(restaurante.getDireccion());
         inicioController.setTelefonoR(restaurante.getTelefono());

         loadMenu(root);
    }

    private static final Random random = new Random();

    public static Repartidor getRandomRepartidor(List<Repartidor> repartidores) {
        if (repartidores == null || repartidores.isEmpty()) {
            throw new IllegalArgumentException("List of repartidores cannot be null or empty");
        }

        int randomIndex = random.nextInt(repartidores.size());
        return repartidores.get(randomIndex);
    }

}
