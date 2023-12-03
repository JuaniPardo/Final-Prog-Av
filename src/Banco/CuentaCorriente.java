package Banco;

public class CuentaCorriente extends Cuenta{

    public CuentaCorriente(int balance, int numeroCuenta){
        super(balance, numeroCuenta);
    }

    public CuentaCorriente(int numeroCuenta){
        super(numeroCuenta);
    }

    @Override
    public void deposito(int monto) {
        if (monto > 0){
            setBalance(getBalance() + monto);
        }
    }

    @Override
    public void extraccion(int monto) {
        if (getBalance() >= monto){
            setBalance(getBalance() - monto);
        }
    }


}
