package Banco.operaciones;

import Banco.ATM.ATM;
import Banco.cuentas.Cuenta;

/**
 * 
 */
public class ConsultaSaldo extends Operacion {

    private Cuenta cuenta;
    public ConsultaSaldo(Cuenta cuenta) {
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
        double balance = getCuenta().getBalance();
        ATM.getInstancia().getSalida().mostrarMensaje("Su balance es: " + balance);
    }



}