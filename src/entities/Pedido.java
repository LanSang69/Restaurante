package entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private String idPedido;
    private LocalDate fecha;
    private LocalTime hora;
    private Double total;
    private Cliente cliente;    // Agregación
    private Repartidor repartidor;  // Composición
    private List<Comida> comidas;
    private List<Bebida> bebidas;
    private List<Postre> postres;

    // Empty Constructor
     public Pedido() {
        this.idPedido = "NO id";
        this.fecha = LocalDate.now();  // Default to the current date
        this.hora = LocalTime.now();   // Default to the current time
        this.total = 0.0;
        this.cliente = new Cliente();  
        this.repartidor = new Repartidor();  
        this.comidas = new ArrayList<>();
        this.bebidas = new ArrayList<>();
        this.postres = new ArrayList<>();
    }

    // Full Constructor
    public Pedido(String idPedido, LocalDate fecha, LocalTime hora, Double total, Cliente cliente,
                  Repartidor repartidor, List<Comida> comidas, List<Bebida> bebidas, List<Postre> postres) {
        this.idPedido = idPedido;
        this.fecha = fecha;
        this.hora = hora;
        this.total = total;
        this.cliente = cliente;
        this.repartidor = new Repartidor(repartidor);
        this.comidas = new ArrayList<>(comidas);
        this.bebidas = new ArrayList<>(bebidas);
        this.postres = new ArrayList<>(postres);
    }

    // Parameterized Constructor
    public Pedido(String id, LocalDate fecha, LocalTime hora, Cliente cliente, Repartidor repartidor) {
        this.idPedido = id;
        this.fecha = fecha;
        this.hora = hora;
        this.cliente = cliente;
        this.repartidor = new Repartidor(repartidor);
    }


    // Getters and Setters
    public Double getTotal() {
        return total;
    }
    
    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Repartidor getRepartidor() {
        return repartidor;
    }

    public void setRepartidor(Repartidor repartidor) {
        this.repartidor = repartidor;
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
}
