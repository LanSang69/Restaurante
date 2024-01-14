package controller;

import java.net.URL;
import java.util.ResourceBundle;

import entities.Pedido;
import entities.Repartidor;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class showPedidos implements Initializable{

    @FXML
    private TableColumn<Pedido, String> cliente;

    @FXML
    private TableColumn<Pedido, String> idP;

    @FXML
    private TableView<Pedido> pedidos;

    @FXML
    private TableColumn<Pedido, String> repartidor;

    @FXML
    private TableColumn<Pedido, Double> totalP;

        ObservableList<Pedido> listR = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idP.setCellValueFactory(new PropertyValueFactory<Pedido, String>("idPedido"));
        cliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCliente().getNombre()));
        repartidor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRepartidor().getNombre()));
        totalP.setCellValueFactory(new PropertyValueFactory<Pedido, Double>("total"));

        pedidos.setItems(listR);
    }

    public void updateList(ObservableList<Pedido> newData) {
        listR.setAll(newData);
    }

}