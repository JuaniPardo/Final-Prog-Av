package Banco.cuentas;

public abstract class Cuenta {

    // EMPIEZA EN 10000 AL SER DE 5 DIGITOS
    private static int cantCuentas = 10000;
    private double balance;
    private int numeroCuenta;
    private String nip;

    //Constructor
    public Cuenta(double balance) {
        // el NIP debe ser de 5 digitos
        setNip("12345");
        setBalance(balance);
        setNumeroCuenta(cantCuentas++);
    }

    //Constructor
    public Cuenta() {
        this(0);
    }

    //Setters y Getters

    public double getBalance() {
        return balance;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
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