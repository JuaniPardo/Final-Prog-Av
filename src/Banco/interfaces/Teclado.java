package Banco.interfaces;

import java.util.Scanner;

/**
 * 
 */
public class Teclado implements Entrada {

    private Scanner scanner;

    public Teclado() {
        this.scanner = new Scanner(System.in);
    }


    @Override
    public int leernumero() {
        return scanner.nextInt();
    }
}