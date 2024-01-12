package entities;

public class Repartidor extends Persona {
    private String medioTransporte;
    private Double calificacion;

    public Repartidor() {
        super();
        medioTransporte = "Medio de Transporte no registrado";
        calificacion = 0.0;
    }

    public Repartidor (Repartidor repartidor) {
        //
        this.medioTransporte = repartidor.medioTransporte;
        this.calificacion = repartidor.calificacion;
    }

    public String getMedioTransporte() {
        return medioTransporte;
    }

    public void setMedioTransporte(String medioTransporte) {
        this.medioTransporte = medioTransporte;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public void mostrarInformacion() {

    }
}
