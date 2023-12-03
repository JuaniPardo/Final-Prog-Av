package Banco.operaciones;

import Banco.ATM.ATM;
import Banco.clientes.Cliente;

public class LogIn extends Operacion{

    private Cliente clienteVerificado;

        public LogIn() {
        }

        public void ejecutar() {
            ATM.getInstancia().getSalida().mostrarMensaje("Bienvenido al ATM");
            ATM.getInstancia().getSalida().mostrarMensaje("Ingrese su numero de cuenta: ");
            int numeroCuenta = ATM.getInstancia().getEntrada().leernumero();
            ATM.getInstancia().getSalida().mostrarMensaje("Ingrese su PIN: ");
            int pin = ATM.getInstancia().getEntrada().leernumero();
            //verificar si la cuenta existe
            //si existe, verificar si el pin es correcto
            ATM.getInstancia().setClienteAutenticado(clienteVerificado);
        }
}
