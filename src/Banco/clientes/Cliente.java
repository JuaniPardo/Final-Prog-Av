package Banco.clientes;

import Banco.cuentas.Cuenta;
import Banco.cuentas.CajaAhorro;

/**
 *
 */
public class Cliente {

    private String nombre;
    private String apellido;
    private Cuenta cuenta;
    private String cuit;

    //Constructor
    public Cliente(String nombre, String apellido, String cuit) {
        setNombre(nombre);
        setApellido(apellido);
        setCuit(cuit);
        setCuenta();
    }

    //Setters y Getters
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getCuit() {
        return cuit;
    }
    public String getNombreCompleto() {
        return getNombre() + " " + getApellido();
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public Cuenta getCuenta() {
        return cuenta;
    }
    public void setCuenta() {
        this.cuenta = new CajaAhorro();
    }
    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    //Metodos

    @Override
    public String toString() {
        return getNombreCompleto() + "\n" +
                "CUIT: " + getCuit() + "\n" +
                String.format("Nro de cuenta: %05d", this.getCuenta().getNumeroCuenta());
    }
}