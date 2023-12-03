package Banco;

import java.util.Scanner;

/**
 * 
 */
public class Teclado implements Entrada {

    private Scanner scanner;


    /**
     * Default constructor
     */

    public Teclado() {
        this.scanner = new Scanner(System.in);
    }


    @Override
    public int leernumero() {
        return scanner.nextInt();
    }
}