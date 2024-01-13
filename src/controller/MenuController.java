package controller;

import entities.Comida;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable{

    @FXML
    private TableView<Comida> comidas;

    @FXML
    private TableColumn<Comida, String> descC;

    @FXML
    private TableColumn<Comida, String> nameC;

    @FXML
    private TableColumn<Comida, Double> precioC;

    ObservableList<Comida> list = FXCollections.observableArrayList(
        new Comida(),
        new Comida("Arroz", 10.99, "Arroz blanco hecho en casa"),
        new Comida("Arroz", 10.99, "Arroz rojo hecho en casa")
    );


    @Override
    public void initialize(URL location, ResourceBundle resources) {
      nameC.setCellValueFactory(new PropertyValueFactory<Comida, String>("nombre"));
      descC.setCellValueFactory(new PropertyValueFactory<Comida, String>("descripcion"));
      precioC.setCellValueFactory(new PropertyValueFactory<Comida, Double>("precio"));

      comidas.setItems(list);
    }

}

