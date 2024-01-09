package entities;

import java.sql.Time;

public class Repartidor extends Persona{
    private String medio;
    private Time tiempo;
    private Double calificacion;

    public Repartidor (Repartidor repartidor){
        this.medio = repartidor.medio;
        this.tiempo = repartidor.tiempo;
        this.calificacion = repartidor.calificacion;
    }
}
