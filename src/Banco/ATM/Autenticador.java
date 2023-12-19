package Banco.ATM;

import Banco.clientes.Cliente;
import Banco.interfaces.Entrada;
import Banco.interfaces.Salida;
import Banco.Banco;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * La clase Autenticador se encarga de autenticar a un cliente del banco mediante
 * la entrada de su número de cuenta y NIP.
 */
public class Autenticador {

    /**
     * Autentica a un cliente del banco solicitando su número de cuenta y NIP.
     *
     * @param banco   El banco que contiene la información de los clientes.
     * @param entrada El objeto de entrada para obtener la información del usuario.
     * @param salida  El objeto de salida para mostrar mensajes al usuario.
     * @return El cliente autenticado o null si la autenticación falla.
     */
    public Cliente autenticarCliente(Banco banco, Entrada entrada, Salida salida) {
        String regex = "^[0-9]{5}$";
        Pattern pattern = Pattern.compile(regex);

        salida.mostrarDivision();
        salida.mostrarMensaje("INGRESAR A MI CUENTA");

        String numeroCuenta = obtenerNumeroCuentaValido(entrada, salida, pattern);
        String nip = obtenerNIPValido(entrada, salida, pattern);

        return buscarCliente(banco, numeroCuenta, nip);
    }

    /**
     * Obtiene un número de cuenta válido del usuario.
     *
     * @param entrada El objeto de entrada para obtener la información del usuario.
     * @param salida  El objeto de salida para mostrar mensajes al usuario.
     * @param pattern El patrón de expresión regular para validar el número de cuenta.
     * @return El número de cuenta válido.
     */
    private String obtenerNumeroCuentaValido(Entrada entrada, Salida salida, Pattern pattern) {
        String numeroCuenta;
        Matcher matcher;
        boolean numeroCuentaValido;

        do {
            salida.mostrarDivision();
            salida.mostrarMensaje("Ingrese su número de cuenta: ");
            numeroCuenta = entrada.leerTexto();
            matcher = pattern.matcher(numeroCuenta);
            numeroCuentaValido = matcher.matches(); // Verificar si coincide con el patrón

            if (!numeroCuentaValido) {
                salida.mostrarDivision();
                salida.mostrarMensaje("Por favor ingrese un número de cuenta de cinco dígitos válido.");
            }
        } while (!numeroCuentaValido);

        return numeroCuenta;
    }

    /**
     * Obtiene un NIP válido del usuario.
     *
     * @param entrada El objeto de entrada para obtener la información del usuario.
     * @param salida  El objeto de salida para mostrar mensajes al usuario.
     * @param pattern El patrón de expresión regular para validar el NIP.
     * @return El NIP válido.
     */
    private String obtenerNIPValido(Entrada entrada, Salida salida, Pattern pattern) {
        String nip;
        Matcher matcher;
        boolean nipValido;

        do {
            salida.mostrarDivision();
            salida.mostrarMensaje("Ingrese su número de identificación personal: ");
            nip = entrada.leerTexto();
            matcher = pattern.matcher(nip);
            nipValido = matcher.matches(); // Verificar si coincide con el patrón

            if (!nipValido) {
                salida.mostrarDivision();
                salida.mostrarMensaje("Por favor ingrese un número de identificación personal de cinco dígitos válido.");
            }
        } while (!nipValido);

        return nip;
    }


    /**
     * Busca al cliente en el banco mediante el número de cuenta y el NIP.
     *
     * @param banco        El banco que contiene la información de los clientes.
     * @param numeroCuenta El número de cuenta del cliente.
     * @param nip          El NIP del cliente.
     * @return El cliente correspondiente al número de cuenta y NIP, o null si no se encuentra.
     */
    private Cliente buscarCliente(Banco banco, String numeroCuenta, String nip) {
        for (Cliente cliente : banco.getClientes()) {
            if (cliente.getCuenta().getNumeroCuenta() == Integer.parseInt(numeroCuenta)
                    && cliente.getCuenta().getNip().equals(nip)) {
                return cliente;
            }
        }
        return null;
    }
}
