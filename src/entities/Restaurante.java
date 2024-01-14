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

    // Constructors
// Constructors
    public Restaurante() {
    this.nombre = "El nombre no ha sido agregado";
    this.direccion = "La dirección no ha sido asignada";
    this.telefono = "Sin teléfono";
    this.comidas = new ArrayList<>();
    this.bebidas = new ArrayList<>();
    this.postres = new ArrayList<>();
    this.repartidores = new ArrayList<>();
    this.clientes = new ArrayList<>();
}

    public Restaurante(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.comidas = new ArrayList<>();
        this.bebidas = new ArrayList<>();
        this.postres = new ArrayList<>();
        this.repartidores = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }


    // Getters and Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Comida> getComidas() {
        return comidas;
    }

    public void setComidas(List<Comida> comidas) {
        this.comidas = comidas;
    }

    public List<Bebida> getBebidas() {
        return bebidas;
    }

    public void setBebidas(List<Bebida> bebidas) {
        this.bebidas = bebidas;
    }

    public List<Postre> getPostres() {
        return postres;
    }

    public void setPostres(List<Postre> postres) {
        this.postres = postres;
    }

    public List<Repartidor> getRepartidores() {
        return repartidores;
    }

    public void setRepartidores(List<Repartidor> repartidores) {
        this.repartidores = repartidores;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    // Métodos para agregar elementos a las listas

    public void agregarComida(Comida comida) {
        comidas.add(comida);
    }

    public void agregarBebida(Bebida bebida) {
        bebidas.add(bebida);
    }

    public void agregarPostre(Postre postre) {
        postres.add(postre);
    }

    public void agregarRepartidor(Repartidor repartidor) {
        repartidores.add(repartidor);
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

}
