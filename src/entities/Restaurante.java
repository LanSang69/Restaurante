package entities;

import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    private String nombre;
    private String direccion;
    private String telefono;
    private List<Pedido> pedidos;
    private List<Comida> comidas;
    private List<Bebida> bebidas;
    private List<Postre> postres;
    private List<Repartidor> repartidores;

    // Constructors
    public Restaurante() {
        this.nombre = "El nombre no ha sido agregado";
        this.direccion = "La dirección no ha sido asignada";
        this.telefono = "Sin teléfono";
        this.comidas = new ArrayList<>();
        this.bebidas = new ArrayList<>();
        this.postres = new ArrayList<>();
        this.repartidores = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }

    public Restaurante(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.comidas = new ArrayList<>();
        this.bebidas = new ArrayList<>();
        this.postres = new ArrayList<>();
        this.repartidores = new ArrayList<>();
        this.pedidos = new ArrayList<>();
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

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    // Métodos para agregar elementos a las listas
    public void agregarComida(Comida comida) {
        if (!comidas.contains(comida)) {
            comidas.add(comida);
        } else {
            System.out.println("¡La comida ya existe!");
        }
    }

    public void agregarBebida(Bebida bebida) {
        if (!bebidas.contains(bebida)) {
            bebidas.add(bebida);
        } else {
            System.out.println("¡La bebida ya existe!");
        }
    }

    public void agregarPostre(Postre postre) {
        if (!postres.contains(postre)) {
            postres.add(postre);
        } else {
            System.out.println("¡El postre ya existe!");
        }
    }

    public void agregarRepartidor(Repartidor repartidor) {
        repartidores.add(repartidor);
    }

    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public Comida comidaEnReseta(String name) {
        for (Comida comida : this.comidas) {
            if (comida.getNombre().equals(name)) {
                return comida; // Name found in the list
            }
        }
        return null;
    }

    public Bebida bebidaEnReceta(String name) {
        for (Bebida bebida : this.bebidas) {
            if (bebida.getNombre().equals(name)) {
                return bebida; // Name found in the list
            }
        }
        return null;
    }

    public Postre postreEnReceta(String name) {
        for (Postre postre : this.postres) {
            if (postre.getNombre().equals(name)) {
                return postre; // Name found in the list
            }
        }
        return null;
    }
}
