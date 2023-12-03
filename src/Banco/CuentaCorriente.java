package Banco;

public class CuentaCorriente extends Cuenta{

    public CuentaCorriente(int balance, int numeroCuenta){
        super(balance, numeroCuenta);
    }

    public CuentaCorriente(int numeroCuenta){
        super(numeroCuenta);
    }

    @Override
    public void deposito(double monto) {
        if (monto > 0.0){
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
