package entities;

public class Repartidor extends Persona {
    private String medioTransporte;
    private Double calificacion;

    // Empty Constructor
    public Repartidor() {
        super(); // Assuming Persona has an empty constructor
        this.medioTransporte = "Medio de Transporte no registrado";
        this.calificacion = 0.0;
    }

     // Full constructor
     public Repartidor(String nombre, String apellido, String direccion, String telefono, String medioTransporte) {
        super(nombre, apellido, direccion, telefono);
        this.medioTransporte = medioTransporte;
        this.calificacion = 0.0;
    }

    // Constructor with attributes from Persona class initialized
    public Repartidor(String nombre, String apellido, String direccion, String telefono) {
        super(nombre, apellido, direccion, telefono);
        this.medioTransporte = "Medio de Transporte no registrado";
        this.calificacion = 0.0;
    }

    // Copy constructor
    public Repartidor(Repartidor repartidor) {
        super(repartidor.nombre, repartidor.apellido, repartidor.direccion, repartidor.telefono);
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
    public String tipoPersona() {
        return "Repartidor";
    }
}
