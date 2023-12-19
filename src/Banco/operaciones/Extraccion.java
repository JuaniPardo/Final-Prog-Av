package Banco.operaciones;

import Banco.ATM.ATM;
import Banco.cuentas.Cuenta;

/**
 * La clase Extracción representa la operación de extracción de dinero de una cuenta.
 */
public class Extraccion extends Operacion {

    /**
     * Constructor que inicializa la operación de extracción con la cuenta especificada.
     *
     * @param cuenta La cuenta de la que se realizará la extracción.
     */
    public Extraccion(Cuenta cuenta) {
        super(cuenta);
    }

    /**
     * Ejecuta la operación de extracción, solicitando al usuario que ingrese el monto a extraer.
     * <p>Este método llama al método {@code extraccion()} de la clase {@code Dispenser}</p>
     * Se muestra el saldo de la cuenta.
     * @see Banco.ATM.Dispenser
     */
    public void ejecutar() {
        ATM.getInstancia().getSalida().mostrarMensaje("Ingrese el monto a extraer: ");
        double monto = ATM.getInstancia().getEntrada().leerNumero();
        ATM.getInstancia().getDispenser().extraccion(monto, getCuenta());
        ATM.getInstancia().getSalida().mostrarMensaje("Su balance es: " + getCuenta().getBalance());
    }
}