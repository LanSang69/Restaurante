package controller;

import java.net.URL;
import java.util.ResourceBundle;

import entities.Comida;
import entities.Repartidor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewRepartidores implements Initializable{

    @FXML
    private TableView<Repartidor> tablaR;
    
    @FXML
    private TableColumn<Repartidor, String> nombreR;

    @FXML
    private TableColumn<Repartidor, String> apellidoR;

    @FXML
    private TableColumn<Repartidor, Double> calificacionR;

    @FXML
    private Button deleteR;

    @FXML
    private TableColumn<Repartidor, String> medioR;

    ObservableList<Repartidor> listR = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nombreR.setCellValueFactory(new PropertyValueFactory<Repartidor, String>("nombre"));
        apellidoR.setCellValueFactory(new PropertyValueFactory<Repartidor, String>("apellido"));
        calificacionR.setCellValueFactory(new PropertyValueFactory<Repartidor, Double>("calificacion"));
        medioR.setCellValueFactory(new PropertyValueFactory<Repartidor, String>("medioTransporte"));

        tablaR.setItems(listR);
    }

    public void updateList(ObservableList<Repartidor> newData) {
        listR.setAll(newData);
    }

    @FXML
    void removeRepartidor(ActionEvent event) {
        int sIndex = tablaR.getSelectionModel().getSelectedIndex();
        tablaR.getItems().remove(sIndex);
    }   

}
