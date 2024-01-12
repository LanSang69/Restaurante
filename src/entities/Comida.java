package entities;
public class Comida implements Receta {
    private String nombre;
    private String precio;
    private String descripcion;
    //

    public Comida() {
        nombre = "Nombre no registrado";
        precio = "Precio no registrado";
        descripcion = "Descripción no registrada";
        //
    }

    public Comida(String nombre, String precio, String descripcion) {
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

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
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
