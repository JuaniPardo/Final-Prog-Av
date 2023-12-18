package Banco.cuentas;

public class CajaAhorro extends Cuenta{

    public CajaAhorro(int balance){
        super(balance);
    }

    public CajaAhorro(){
        super();
    }

    @Override
    public void deposito(double monto) {
        if (monto > 0){
            setBalance(getBalance() + monto);
        }
    }

    @Override
    public void extraccion(double monto) {
        if (getBalance() >= monto){
            setBalance(getBalance() - monto);
        }
    }


}
