package entities;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public class Pedido {
    private int idPedido;
    private Date fecha;
    private Time hora;
    private Cliente cliente;    //Agregación
    private Repartidor repartidor;  //Composición
    private List<Comida> comidas;
    private List<Bebida> bebidas;
    private List<Postre> postres;
    protected String apellido;
    public Pedido(int id, Date fecha, Cliente cliente, Repartidor repartidor) {
        this.idPedido = id;
        this.fecha = fecha;
        this.cliente = cliente; 
        this.repartidor = new Repartidor(repartidor); 
    }
}
