package controller;

import java.net.URL;
import java.util.ResourceBundle;

import entities.Receta;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PedidoController implements Initializable{

    @FXML
    private Button agregar;

        @FXML
    private ChoiceBox<String> metodoPago;

    @FXML
    private TableView<Receta> carrito;

    @FXML
    private TableColumn<Receta, String> platillo;

    @FXML
    private TableColumn<Receta, String> precio;

    @FXML
    private TextField cantidadP;
    
    @FXML
    private TextArea direccionC;
    
    @FXML
    private TextField nombreC;
    
    @FXML
    private TextField nombreP;
    
    @FXML
    private Button pedidoB;
    
    @FXML
    private TextField telC;
    
    @FXML
    private TextField total;

        @FXML
    private Label successP;
    
    @FXML
    private Button terminarC;

    ObservableList<Receta> listR = FXCollections.observableArrayList();
    String[] metodos = {"Efectivo", "Tarjeta"};

    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        metodoPago.getItems().addAll(metodos);

        platillo.setCellValueFactory(new PropertyValueFactory<Receta, String>("nombre"));
        precio.setCellValueFactory(new PropertyValueFactory<Receta, String>("precio"));

        carrito.setItems(listR);

        // Calculate and set the total when the list changes
        listR.addListener((ListChangeListener.Change<? extends Receta> c) -> {
            updateTotal();
        });
    }

    // Method to update the total based on the sum of precio values
    private void updateTotal() {
        double sum = 0.0;
        for (Receta receta : listR) {
            // Assuming that the "precio" property in Receta is of type Double
            sum += receta.getPrecio();
        }
        setTotal(sum);
    }


    public void setSuccess(String smt){
        this.successP.setText(smt);
    }

    public Label getSuccess(){
        return this.successP;
    }

    public void updateList(ObservableList<Receta> newData) {
        listR.setAll(newData);
    }

    public void addR(Receta platillo){
        listR.add(platillo);
    }

    // Getters and Setters
    public String getSelection(){
        return this.metodoPago.getValue();
    }

    public Button getAgregar() {
        return agregar;
    }

    public TextArea getDireccionC() {
        return direccionC;
    }

    public void setDireccion(String d){
        this.direccionC.setText(d);
    }

    public TextField getNombreC() {
        return nombreC;
    }

    public void setNombreCliente(String c){
        this.nombreC.setText(c);
    }

    public TextField getNombreP() {
        return nombreP;
    }

    public void setNombreProducto(String p){
        this.nombreP.setText(p);
    }
    
    public TextField getTelC() {
        return telC;
    }

    public void setTelC(String t){
        this.telC.setText(t);
    }

    public TextField getTotal() {
        return total;
    }

    public void setTotal(Double total){
        this.total.setText(Double.toString(total));
    }

    public Button getTerminarC() {
        return terminarC;
    }

    public Button getPedidoB() {
        return pedidoB;
    }

     @FXML
    void removePlatillo(ActionEvent event) {
        int sIndex = carrito.getSelectionModel().getSelectedIndex();
        carrito.getItems().remove(sIndex);
    }  
    
    void clear(){
        carrito.getItems().removeAll();
    }


}
