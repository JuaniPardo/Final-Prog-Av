package Banco.operaciones;

import Banco.ATM.ATM;
import Banco.cuentas.Cuenta;

public class Deposito extends Operacion {

    private Cuenta cuenta;
    private double monto;

    //Constructor
    public Deposito(Cuenta cuenta) {
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
        //obtener monto y sumarlo al balance de la cuenta
        ATM.getInstancia().getSalida().mostrarMensaje("Ingrese el monto a depositar: ");
        monto = ATM.getInstancia().getEntrada().leernumero();
        getCuenta().deposito(monto);
        ATM.getInstancia().getSalida().mostrarMensaje("Su nuevo balance es: " + getCuenta().getBalance());
    }
}