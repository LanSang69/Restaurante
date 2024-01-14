package entities;
public class Bebida implements Receta {
    private String nombre;
    private Double precio;
    private String descripcion;
    //

    public Bebida() {
        nombre = "Nombre no registrado";
        precio = 0.0;
        descripcion = "Descripción no registrada";
        //
    }

    public Bebida(String nombre, Double precio, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        //
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public void actualizarInformacion() {
        
    }
}
