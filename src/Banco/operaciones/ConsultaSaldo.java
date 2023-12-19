package Banco.operaciones;

import Banco.ATM.ATM;
import Banco.cuentas.Cuenta;

public class ConsultaSaldo extends Operacion {

    public ConsultaSaldo(Cuenta cuenta) {
        super(cuenta);
    }

    public void ejecutar() {
        double balance = getCuenta().getBalance();
        ATM.getInstancia().getSalida().mostrarMensaje("Su balance es: " + balance);
    }
}