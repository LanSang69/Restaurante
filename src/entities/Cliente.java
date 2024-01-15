package entities;

public class Cliente extends Persona {
    private String metodoPago;
    
    public Cliente() {
        super();
        metodoPago = "Método de Pago no registrado";
    }

     // Full constructor
     public Cliente(String nombre, String direccion, String telefono, String metodoPago) {
        super(nombre, direccion, telefono);
        this.metodoPago = metodoPago;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    @Override
    public String tipoPersona() {
        return "Cliente";
    }
}
