package Banco.ATM;

import Banco.Banco;
import Banco.cuentas.Cuenta;
import Banco.interfaces.Entrada;
import Banco.interfaces.Pantalla;
import Banco.interfaces.Salida;
import Banco.interfaces.Teclado;
import Banco.operaciones.Operacion;
import Banco.clientes.Cliente;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public class ATM {


    public static final ATM instancia = new ATM();
    private Cliente clienteAutenticado;
    private Entrada entrada;
    private Salida salida;
    private Dispenser dispenser;
    private Banco banco;

    //Constructor Singleton
    private ATM() {
        setEntrada();
        setSalida();
        dispenser = new Dispenser();
    }

    public static ATM getInstancia() {
        return instancia;
    }

    //Setters y Getters


    public Cliente getClienteAutenticado() {
        return clienteAutenticado;
    }

    public void setClienteAutenticado(Cliente clienteAutenticado) {
        this.clienteAutenticado = clienteAutenticado;
    }

    public Entrada getEntrada() {
        return entrada;
    }

    public Salida getSalida() {
        return salida;
    }

    public void setEntrada() {
        this.entrada = new Teclado();
    }

    public void setSalida() {
        this.salida = new Pantalla();
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public void ejecutarOperacion(Operacion operacion) {
        operacion.ejecutar();
    }

    public int mostrarMenuBienvenida() {
        String mensajeBienvenida = "BIENVENIDO AL CAJERO ATM";
        int opcion = 0;
        this.salida.mostrarDivision();
        this.salida.mostrarMensaje(mensajeBienvenida);
        this.salida.mostrarDivision();
        this.salida.mostrarMensaje("[1] Ingresar a mi cuenta");
        this.salida.mostrarMensaje("[2] Salir");
        this.salida.mostrarDivision();
        this.salida.mostrarMensaje("Ingrese su opcion: ");
        try {
            opcion = Integer.parseInt(this.entrada.leer());
            if (opcion != 1 && opcion != 2) {
                opcion = 0;
                throw new Exception();
            }
        } catch (Exception e) {
            this.salida.mostrarDivision();
            this.salida.mostrarMensaje("Por favor ingrese un valor valido (Ej=1)");
            this.salida.mostrarDivision();
        }
        return opcion;
    }

    public int mostrarMenuOperaciones() {
        String mensajeBienvenida = "HOLA "
                + clienteAutenticado.getNombre()
                + " "
                + clienteAutenticado.getApellido()
                + "!";
        int opcion = 0;
        this.salida.mostrarDivision();
        this.salida.mostrarMensaje(mensajeBienvenida);
        this.salida.mostrarDivision();
        this.salida.mostrarMensaje("[1] Consultar saldo");
        this.salida.mostrarMensaje("[2] Retirar efectivo");
        this.salida.mostrarMensaje("[3] Realizar depósito");
        this.salida.mostrarMensaje("[4] Salir");
        this.salida.mostrarDivision();
        this.salida.mostrarMensaje("Ingrese su opcion: ");
        try {
            opcion = Integer.parseInt(this.entrada.leer());
            if (opcion < 1 || opcion > 4) {
                opcion = 0;
                throw new Exception();
            }

            switch (opcion) {
                case 1:
                case 2:
                case 3:
                case 4:
                    this.setClienteAutenticado(null);
                    break;
            }

        } catch (Exception e) {
            this.salida.mostrarDivision();
            this.salida.mostrarMensaje("Por favor ingrese\n un valor valido (Ej=1)");
            this.salida.mostrarDivision();
        }
        return opcion;
    }

    public void mostrarIniciarSesion() {
        String regex = "^[0-9]{5}$";
        Pattern pattern = Pattern.compile(regex);
        this.salida.mostrarDivision();
        this.salida.mostrarMensaje("INGRESAR A MI CUENTA");
        String numeroCuenta = "";
        Matcher matcher = pattern.matcher(numeroCuenta);
        while (!matcher.hasMatch()) {
            this.salida.mostrarDivision();
            this.salida.mostrarMensaje("Ingrese su numero de cuenta: ");
            numeroCuenta = this.entrada.leer();
            matcher = pattern.matcher(numeroCuenta);
            if (!matcher.find()) {
                this.salida.mostrarDivision();
                this.salida.mostrarMensaje("""
                        Por favor ingrese un numero
                        de cuenta de cinco digitos
                        valido.""");
                numeroCuenta = "";
            }
        }
        String nip = "";
        matcher = pattern.matcher(nip);
        while(!matcher.hasMatch()) {
            this.salida.mostrarDivision();
            this.salida.mostrarMensaje("Ingrese su numero\nde identificacion personal: ");
            nip = this.entrada.leer();
            matcher = pattern.matcher(nip);
            if (!matcher.find()) {
                this.salida.mostrarDivision();
                this.salida.mostrarMensaje("""
                        Por favor ingrese un numero
                        de identificacion personal
                        de cinco digitos valido.""");
                nip = "";
            }
        }

        for (Cliente cliente : this.banco.getClientes()) {

            Cuenta cuenta = cliente.getCuenta();
            if (cuenta.getNumeroCuenta() == Integer.parseInt(numeroCuenta)
                    && cuenta.getNip().equals(nip)) {
                this.clienteAutenticado = cliente;
                break;
            }

        }

    }

    @Override
    public String toString() {
        return "ATM{" +
                "cuentaAutenticada=" + clienteAutenticado +
                ", entrada=" + entrada +
                ", salida=" + salida +
                '}';
    }
}