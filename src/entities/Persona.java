package entities;

public abstract class Persona {
    protected String nombre;
    protected String apellido;
    protected String direccion;
    protected String telefono;

    public Persona() {
        
    }



    public abstract void mostrarInformacion();
}
