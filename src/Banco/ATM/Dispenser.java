package Banco.ATM;

import Banco.cuentas.Cuenta;

/**
 * La clase Dispenser representa el dispensador de billetes de un cajero automático.
 * Permite realizar recargas de billetes, consultas de efectivo disponible y realizar extracciones.
 */
public class Dispenser {
    private static final int VALOR_BILLETE = 20;
    private static final int BILLETES_INICIALES = 500;

    private int billetes;

    public Dispenser() {
        this.recarga();
    }

    public int getBilletes() {
        return billetes;
    }

    public void recarga() {
        this.billetes = BILLETES_INICIALES;
    }

    /**
     * Realiza una extracción de efectivo del dispensador, verificando la disponibilidad de billetes y la suficiencia de saldo en la cuenta del usuario.
     * <p>Para esto, invoca el método {@code extraccion()} de la clase {@code Cuenta}</p>

     * @param monto  El monto a extraer.
     * @param cuenta La cuenta asociada al usuario que realiza la extracción.
     * @see Cuenta
     */
    public void extraccion(double monto, Cuenta cuenta) {
        if (monto % VALOR_BILLETE != 0) {
            ATM.getInstancia().getSalida().mostrarMensaje("En este momento solo podemos entregar múltiplos de $" + VALOR_BILLETE);
            return;
        }

        int billetesExtraccion = (int) (monto / VALOR_BILLETE);

        if (monto <= this.efectivo() && cuenta.extraccion(monto)) {
            billetes -= billetesExtraccion;
            ATM.getInstancia().getSalida().mostrarMensaje("Extracción exitosa");
        } else {
            if (billetesExtraccion > billetes) {
                ATM.getInstancia().getSalida().mostrarMensaje("No hay suficientes billetes en el ATM");
            } else {
                ATM.getInstancia().getSalida().mostrarMensaje("Saldo Insuficiente");
            }
        }
    }

    private int efectivo() {
        return billetes * VALOR_BILLETE;
    }
}