package Banco.ATM;

public class Dispenser {
    private int billetes;

    public Dispenser() {
        this.recarga();
    }

    public void recarga() {
        this.billetes = 500;
    }

    public void extraccion(int monto) {
        if (monto % 20 != 0) {
            ATM.getInstancia().getSalida().mostrarMensaje("En este momento solo podemos entregar múltiplos de $20");
        } else {
            if (monto <= this.efectivo()) {
                int billetesExtraccion = monto / 20;
                billetes -= billetesExtraccion;
                //TODO: mostrar saldo
            } else {

            }
        }
    }

    private int efectivo() {
        return billetes * 20;
    }
}
