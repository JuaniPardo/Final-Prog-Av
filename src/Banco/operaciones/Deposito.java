package Banco.operaciones;

import Banco.ATM.ATM;
import Banco.cuentas.Cuenta;

public class Deposito extends Operacion {

    /**
     * Constructor que inicializa la operación de depósito con la cuenta especificada.
     *
     * @param cuenta La cuenta en la que se realizará el depósito.
     */
    public Deposito(Cuenta cuenta) {
        super(cuenta);
    }

    /**
     * Ejecuta la operación de depósito, utilizando el lector de billetes para obtener el monto y
     * actualizando el saldo de la cuenta.
     */
    public void ejecutar() {
        // Simulación: Obtener el monto del lector de billetes
        ATM.getInstancia().getSalida().mostrarMensaje("Ingrese billetes en el lector.");
        double monto = obtenerMontoDelLectorDeBilletes();
        getCuenta().deposito(monto);
        ATM.getInstancia().getSalida().mostrarMensaje("Su nuevo balance es: " + getCuenta().getBalance());
    }

    /**
     * Simulación: Obtener el monto del lector de billetes.
     *
     * @return El monto obtenido del lector de billetes.
     */
    private double obtenerMontoDelLectorDeBilletes() {
        ATM.getInstancia().getSalida().mostrarMensaje("(MODO DEV - Ingrese el monto a depositar - MODO DEV): ");

        return ATM.getInstancia().getEntrada().leerNumero();
    }
}