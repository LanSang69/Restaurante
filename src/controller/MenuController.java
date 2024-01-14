package controller;

import entities.Bebida;
import entities.Comida;
import entities.Postre;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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

    @FXML
    private TableView<Bebida> bebidas;

    @FXML
    private TableColumn<Bebida, String> descB;
  
    @FXML
    private TableColumn<Bebida, String> nameB;
    
    @FXML
    private TableColumn<Bebida, Double> precioB;
   
    @FXML
    private TableView<Postre> postres;

    @FXML
    private TableColumn<Postre, String> descP;

    @FXML
    private TableColumn<Postre, String> nameP;


    @FXML
    private TableColumn<Postre, Double> precioP;

     @FXML
    private ChoiceBox<String> tipoComida;

    private String[] platillos = {"Comidas", "Bebidas", "Postres"};

    ObservableList<Comida> listC = FXCollections.observableArrayList();
    ObservableList<Bebida> listB = FXCollections.observableArrayList();
    ObservableList<Postre> listP = FXCollections.observableArrayList();



    @Override
    public void initialize(URL location, ResourceBundle resources) {
      //Agrego las secciones del checkbox
      tipoComida.getItems().addAll(platillos);
      tipoComida.setOnAction(e->{
        String selectedOption = tipoComida.getValue();

        // Perform actions based on the selected option
        switch (selectedOption) {
            case "Comidas":
                setOpacityForTables(1, 0, 0);
                break;
            case "Bebidas":
                setOpacityForTables(0, 1, 0);
                break;
            case "Postres":
                setOpacityForTables(0, 0, 1);
                break;
            default:
                // Handle other options if needed
        }
      });

      nameC.setCellValueFactory(new PropertyValueFactory<Comida, String>("nombre"));
      descC.setCellValueFactory(new PropertyValueFactory<Comida, String>("descripcion"));
      precioC.setCellValueFactory(new PropertyValueFactory<Comida, Double>("precio"));
      nameB.setCellValueFactory(new PropertyValueFactory<Bebida, String>("nombre"));
      descB.setCellValueFactory(new PropertyValueFactory<Bebida, String>("descripcion"));
      precioB.setCellValueFactory(new PropertyValueFactory<Bebida, Double>("precio"));
      nameP.setCellValueFactory(new PropertyValueFactory<Postre, String>("nombre"));
      descP.setCellValueFactory(new PropertyValueFactory<Postre, String>("descripcion"));
      precioP.setCellValueFactory(new PropertyValueFactory<Postre, Double>("precio"));

      comidas.setItems(listC);
      bebidas.setItems(listB);
      postres.setItems(listP);
    }

    public void updateList(ObservableList<Comida> newData) {
      listC.setAll(newData);
  }

    public void updateListB(ObservableList<Bebida> newData) {
      listB.setAll(newData);
  }

    public void updateListP(ObservableList<Postre> newData) {
      listP.setAll(newData);
    }

  // Set opacity for TableView components
  private void setOpacityForTables(double opacityC, double opacityB, double opacityP) {
      comidas.setOpacity(opacityC);
      bebidas.setOpacity(opacityB);
      postres.setOpacity(opacityP);
  }

}