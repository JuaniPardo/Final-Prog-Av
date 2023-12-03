package Banco.operaciones;

import Banco.ATM.ATM;

public class LogOut extends Operacion{

        public LogOut() {
        }

        public void ejecutar() {
            ATM.getInstancia().getSalida().mostrarMensaje("Gracias por usar el ATM");
            ATM.getInstancia().getSalida().mostrarMensaje("Hasta luego");
            ATM.getInstancia().setClienteAutenticado(null);
        }
}
