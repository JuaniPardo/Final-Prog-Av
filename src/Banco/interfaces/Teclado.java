package Banco.interfaces;

import java.util.Scanner;

public class Teclado implements Entrada {

    private Scanner scanner;

    public Teclado() {
        this.scanner = new Scanner(System.in);
    }


    @Override
    public String leerTexto() {
        return scanner.next();
    }

    @Override
    public int leerNumero() {
        return scanner.nextInt();
    }
}