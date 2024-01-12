package entities;

public class Cliente extends Persona {
    private String metodoPago;
    private String correo;
    
    public Cliente() {
        super();
        metodoPago = "Método de Pago no registrado";
        correo = "Correo no registrado";
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public void mostrarInformacion() {
        
    }
}
