package Banco.operaciones;

import Banco.ATM.ATM;
import Banco.cuentas.Cuenta;

public class Extraccion extends Operacion {

    private Cuenta cuenta;
    private double monto;

    //Constructor
    public Extraccion(Cuenta cuenta) {
        super();
        setCuenta(cuenta);
    }

    //Setters and Getters
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Cuenta getCuenta() {
        return this.cuenta;
    }

    public void ejecutar() {
        ATM.getInstancia().getSalida().mostrarMensaje("Ingrese el monto a extraer: ");
        monto = ATM.getInstancia().getEntrada().leerNumero();
        getCuenta().extraccion(monto);
        ATM.getInstancia().getSalida().mostrarMensaje("Su nuevo balance es: " + getCuenta().getBalance());
    }

}