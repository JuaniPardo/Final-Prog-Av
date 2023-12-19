package Banco.operaciones;

import Banco.ATM.ATM;
import Banco.cuentas.Cuenta;

/**
 * La clase abstracta Operacion representa una operación bancaria genérica.
 * @see Banco.operaciones.Extraccion
 * @see Banco.operaciones.Deposito
 * @see Banco.operaciones.ConsultaSaldo

 */
public abstract class Operacion {

    private Cuenta cuenta;

    public Operacion(Cuenta cuenta) {
        setCuenta(cuenta);
    }

    public abstract void ejecutar();

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Cuenta getCuenta() {
        return this.cuenta;
    }

    public void menuPostOperacion(){
        ATM.getInstancia().getSalida().mostrarDivision();
        ATM.getInstancia().getSalida().mostrarMensaje("¿Desea realizar otra operación?");
        ATM.getInstancia().getSalida().mostrarMensaje("[1] Sí");
        ATM.getInstancia().getSalida().mostrarMensaje("[2] No");
        int opcion = ATM.getInstancia().getEntrada().leerNumero();
        if (opcion == 2) {
            setCuenta(null);
        }
    }

}