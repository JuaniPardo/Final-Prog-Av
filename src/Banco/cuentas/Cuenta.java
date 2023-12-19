package Banco.cuentas;

public abstract class Cuenta {

    /** El PIN debe ser de 5 digitos.
     * Es un String y la validación se maneja con un try-catch que compara con una regex.
     * No hay problema con que empiece en 0, ya que no se maneja como un número.
     * Si yo escribo "00000" no es lo mismo que "0".
     */
    private static int cantCuentas = 0;
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

    public abstract boolean extraccion(double monto);

    public double consultaSaldo() {
        return getBalance();
    }

    @Override
    public String toString() {
        return "Cuenta{" + "balance=" + balance + ", numeroCuenta=" + numeroCuenta + '}';
    }

}