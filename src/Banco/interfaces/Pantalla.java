package Banco.interfaces;

public class Pantalla implements Salida {

    public Pantalla() {
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarDivision() {
        System.out.println("------------------------------------");
    }
}