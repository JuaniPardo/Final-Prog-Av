package Banco.interfaces;

import Banco.ATM.ATM;

import java.util.Scanner;

/**
 * La clase Teclado implementa la interfaz Entrada y proporciona métodos para la entrada de datos desde el teclado.
 */
public class Teclado implements Entrada {

    private final Scanner scanner;

    public Teclado() {
        this.scanner = new Scanner(System.in);
    }


    @Override
    public String leerTexto() {
        return scanner.next();
    }

    /**
     * Lee un número entero desde la entrada estándar, asegurándose de que el valor ingresado sea un número válido.
     *
     * @return El número entero ingresado por el usuario.
     */
    @Override
    public int leerNumero() {
        String sNum = leerTexto();
        while (!sNum.matches("[0-9]+")) {
            ATM.getInstancia().getSalida().mostrarMensaje("Ingrese un numero valido: ");
            sNum = leerTexto();
        }
        return Integer.parseInt(sNum);
    }
}