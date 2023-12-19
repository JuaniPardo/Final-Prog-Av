package Banco.ATM;

import Banco.Banco;
import Banco.interfaces.Entrada;
import Banco.interfaces.Pantalla;
import Banco.interfaces.Salida;
import Banco.interfaces.Teclado;
import Banco.operaciones.ConsultaSaldo;
import Banco.operaciones.Deposito;
import Banco.operaciones.Extraccion;
import Banco.operaciones.Operacion;
import Banco.clientes.Cliente;


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
    private Autenticador autenticador;

    //Constructor Singleton
    private ATM() {
        setEntrada();
        setSalida();
        autenticador = new Autenticador();
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
    public Dispenser getDispenser() {
        return dispenser;
    }

    //Metodos
    public void ejecutarOperacion(Operacion operacion) {
        operacion.ejecutar();
    }

    //Metodos
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
            opcion = Integer.parseInt(this.entrada.leerTexto());
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
        this.salida.mostrarMensaje("(Billetes = " + this.dispenser.getBilletes() + ")");
        this.salida.mostrarDivision();
        this.salida.mostrarMensaje("Ingrese su opcion: ");
        try {
            opcion = Integer.parseInt(this.entrada.leerTexto());
            if (opcion < 1 || opcion > 4) {
                opcion = 0;
                throw new Exception();
            }

            switch (opcion) {
                case 1:
                    consultarSaldo();
                    break;
                case 2:
                    retirarEfectivo();
                    break;
                case 3:
                    realizarDeposito();
                    break;
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
        clienteAutenticado = autenticador.autenticarCliente(banco, entrada, salida);

        if (clienteAutenticado == null) {
            salida.mostrarDivision();
            salida.mostrarMensaje("Número de cuenta o NIP incorrecto. Por favor, inténtelo nuevamente.");
            salida.mostrarDivision();
        }
    }

    public void consultarSaldo() {
        if (this.clienteAutenticado != null) {
            Operacion consultarSaldo = new ConsultaSaldo(this.clienteAutenticado.getCuenta());
            this.ejecutarOperacion(consultarSaldo);
        } else {
            this.salida.mostrarDivision();
            this.salida.mostrarMensaje("Por favor inicie sesión para realizar esta operación.");
            this.salida.mostrarDivision();
        }
    }

    public void retirarEfectivo() {
        if (this.clienteAutenticado != null) {
            Operacion retirarEfectivo = new Extraccion(this.clienteAutenticado.getCuenta());
            this.ejecutarOperacion(retirarEfectivo);
        } else {
            this.salida.mostrarDivision();
            this.salida.mostrarMensaje("Por favor inicie sesión para realizar esta operación.");
            this.salida.mostrarDivision();
        }
    }

    public void realizarDeposito() {
        if (this.clienteAutenticado != null) {
            Operacion realizarDeposito = new Deposito(this.clienteAutenticado.getCuenta());
            this.ejecutarOperacion(realizarDeposito);
        } else {
            this.salida.mostrarDivision();
            this.salida.mostrarMensaje("Por favor inicie sesión para realizar esta operación.");
            this.salida.mostrarDivision();
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