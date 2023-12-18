package Banco.cuentas;

public abstract class Cuenta {

    private static int cantCuentas = 0;
    private double balance;
    private int numeroCuenta;

    //Constructor
    public Cuenta(double balance) {
        setBalance(balance);
        setNumeroCuenta(cantCuentas++);
    }

    //Constructor
    public Cuenta() {
        this.balance = 0;
    }

    //Setters y Getters

    public double getBalance() {
        return balance;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    //Metodos

    public abstract void deposito(double monto);

    public abstract void extraccion(double monto);

    public double consultaSaldo() {
        return getBalance();
    }

    @Override
    public String toString() {
        return "Cuenta{" + "balance=" + balance + ", numeroCuenta=" + numeroCuenta + '}';
    }

}