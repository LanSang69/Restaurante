package entities;

import java.util.Date;

public class Pedido {
    private int idPedido;
    private Date datetime;
    private Cliente cliente;    //Agregación
    private Repartidor repartidor;  //Composición

    public Pedido(int id, Date fecha, Cliente cliente, Repartidor repartidor) {
        this.idPedido = id;
        this.datetime = fecha;
        this.cliente = cliente; 
        this.repartidor = new Repartidor(repartidor); 
    }
}
