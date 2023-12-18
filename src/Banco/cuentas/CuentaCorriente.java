package Banco.cuentas;

public class CuentaCorriente extends Cuenta{

    public CuentaCorriente(int balance){
        super(balance);
    }

    public CuentaCorriente(){
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
