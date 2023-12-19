package Banco.operaciones;

import Banco.ATM.ATM;
import Banco.cuentas.Cuenta;

/**
 * La clase {@code CambiarPIN} representa la operación de cambiar el NIP de una cuenta en un cajero automático.
 * Extiende la clase abstracta {@code Operacion}.
 */
public class CambiarPIN extends Operacion {

    /**
     * Constructor que inicializa la operación de cambiar el NIP con la cuenta especificada.
     *
     * @param cuenta La cuenta en la que se cambiará el NIP.
     */
    public CambiarPIN(Cuenta cuenta) {
        super(cuenta);
    }


    /**
     * Ejecuta la operación de cambiar el NIP solicitando al usuario el NIP actual, el nuevo NIP
     * y la confirmación del nuevo NIP. Verifica la autenticación y realiza el cambio si es válido.
     */
    @Override
    public void ejecutar() {
        ATM.getInstancia().getSalida().mostrarMensaje("Ingrese su NIP: ");
        int nip = ATM.getInstancia().getEntrada().leerNumero();
        ATM.getInstancia().getSalida().mostrarMensaje("Ingrese su nuevo NIP: ");
        int nuevoNip = ATM.getInstancia().getEntrada().leerNumero();
        ATM.getInstancia().getSalida().mostrarMensaje("Confirme su nuevo NIP: ");
        int confirmacionNip = ATM.getInstancia().getEntrada().leerNumero();
        String nipString = Integer.toString(nip);
        // Verifica la autenticación del NIP actual
        if (nipString.equals(getCuenta().getNip())) {
            // Verifica que el nuevo NIP coincida con la confirmación
            if (nuevoNip == confirmacionNip) {
                // Actualiza el NIP de la cuenta
                getCuenta().setNip(Integer.toString(nuevoNip));
                ATM.getInstancia().getSalida().mostrarMensaje("Su nuevo NIP es: " + getCuenta().getNip());
            } else {
                ATM.getInstancia().getSalida().mostrarMensaje("Los NIP no coinciden.");
            }
        } else {
            ATM.getInstancia().getSalida().mostrarMensaje("NIP incorrecto.");
        }
    }
}
