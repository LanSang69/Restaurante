package entities;
import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    private String nombre;
    private String direccion;
    private String telefono;
    private List<Comida> comidas;
    private List<Bebida> bebidas;
    private List<Postre> postres;
    private List<Repartidor> repartidores;
    private List<Cliente> clientes;

    public Restaurante(){
        this.nombre = "El nombre no ha sido agregado";
        this.direccion = "La dirección no ha sido asignada";
        this.telefono = "Sin teléfono";
    }

    public Restaurante(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }
}
