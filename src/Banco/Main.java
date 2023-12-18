package Banco;

import Banco.ATM.ATM;

public class Main {
    public static void main(String[] args) {

        Banco banco = new Banco("Banco Galicia",
                "Banco de Galicia y Buenos Aires S.A.",
                "30-50000173-5");

        cargarClientes(banco);

        ATM cajero = ATM.getInstancia();
        cajero.setBanco(banco);

        int opcion = 0;

        while(opcion != 2) {
            opcion = cajero.mostrarMenuBienvenida();
            if(opcion == 1) {
                cajero.mostrarIniciarSesion();
                while(cajero.getClienteAutenticado() != null) {
                    cajero.mostrarMenuOperaciones();
                }
            }
        }
    }

    public static void cargarClientes(Banco banco) {
        banco.agregarCliente("Lucas", "Caraballo", "20-4538075-8");
        banco.agregarCliente("Juan Ignacio", "Pardo", "25-3028512-5");
    }

}
