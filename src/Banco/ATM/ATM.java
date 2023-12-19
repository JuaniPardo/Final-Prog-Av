package Banco.ATM;

import Banco.Banco;
import Banco.interfaces.Entrada;
import Banco.interfaces.Pantalla;
import Banco.interfaces.Salida;
import Banco.interfaces.Teclado;
import Banco.operaciones.CambiarPIN;
import Banco.operaciones.ConsultaSaldo;
import Banco.operaciones.Deposito;
import Banco.operaciones.Extraccion;
import Banco.operaciones.Operacion;
import Banco.clientes.Cliente;


/**
 * La clase {@code ATM} representa un cajero automático que interactúa con un banco
 * para realizar operaciones bancarias. Es un componente central que gestiona la autenticación
 * de clientes, las operaciones financieras y la interacción con el usuario a través de la entrada
 * y salida configuradas.
 *
 * <p>Esta clase sigue el patrón de diseño Singleton, asegurando que solo haya una instancia de
 * {@code ATM} en la aplicación.</p>
 *
 * <p>Para utilizar el cajero automático, se debe obtener la instancia mediante el método
 * {@code getInstancia()} y luego se pueden realizar diversas operaciones llamando a los métodos
 * proporcionados.</p>
 *
 * @see Cliente
 * @see Banco
 * @see Operacion
 * @see Entrada
 * @see Salida
 * @see Teclado
 * @see Pantalla
 * @see Dispenser
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
    /**
     * Ejecuta una operación bancaria dada. Si el cliente está autenticado, la operación se realiza,
     * de lo contrario, se muestra un mensaje indicando que se debe iniciar sesión para realizar la operación.
     *
     * @param operacion La operación bancaria a ejecutar.
     * @see Operacion
     */
    public void ejecutarOperacion(Operacion operacion) {
        if (this.clienteAutenticado != null) {
            operacion.ejecutar();
            operacion.menuPostOperacion();
        } else {
            this.salida.mostrarDivision();
            this.salida.mostrarMensaje("Por favor inicie sesión para realizar esta operación.");
            this.salida.mostrarDivision();
        }
    }

    /**
     * Muestra el menú de bienvenida en la pantalla, permitiendo al usuario elegir entre ingresar a su cuenta
     * o salir del cajero automático.
     *
     * @return La opción seleccionada por el usuario.
     */
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

    /**
     * Muestra el menú de operaciones disponibles después de que el cliente ha iniciado sesión.
     * Presenta opciones como consultar saldo, retirar efectivo, realizar depósito o salir.
     *
     * @return La opción seleccionada por el usuario.
     */
    public void mostrarMenuOperaciones() {
        String mensajeBienvenida = "HOLA "
                + clienteAutenticado.getNombre()
                + " "
                + clienteAutenticado.getApellido()
                + "!";
        int opcion = 0;
        this.salida.mostrarDivision();
        this.salida.mostrarMensaje(mensajeBienvenida);
        this.salida.mostrarDivision();
        this.salida.mostrarMensaje("(MODO DEV - Billetes = " + this.dispenser.getBilletes() + " - MODO DEV)");
        this.salida.mostrarMensaje("[1] Consultar saldo");
        this.salida.mostrarMensaje("[2] Retirar efectivo");
        this.salida.mostrarMensaje("[3] Realizar depósito");
        this.salida.mostrarMensaje("[4] Cambiar PIN");
        this.salida.mostrarMensaje("[0] Salir");
        this.salida.mostrarDivision();
        this.salida.mostrarMensaje("Ingrese su opcion: ");
        try {
            opcion = Integer.parseInt(this.entrada.leerTexto());
            if (opcion < 0 || opcion > 4) {
                opcion = -1;
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
                    cambiarPin();
                    break;
                case 0:
                    this.setClienteAutenticado(null);
                    break;
            }

        } catch (Exception e) {
            this.salida.mostrarDivision();
            this.salida.mostrarMensaje("Por favor ingrese\n un valor valido (Ej=1)");
            this.salida.mostrarDivision();
        }
    }

    /**
     * Muestra el proceso de inicio de sesión, autenticando al cliente con el banco.
     * Si la autenticación es exitosa, el cliente queda autenticado para realizar operaciones,
     * de lo contrario, se muestra un mensaje de error.
     */
    public void mostrarIniciarSesion() {
        clienteAutenticado = autenticador.autenticarCliente(banco, entrada, salida);

        if (clienteAutenticado == null) {
            salida.mostrarDivision();
            salida.mostrarMensaje("Número de cuenta o NIP incorrecto. Por favor, inténtelo nuevamente.");
            salida.mostrarDivision();
        }
    }

    public void consultarSaldo() {
        this.ejecutarOperacion(new ConsultaSaldo(this.clienteAutenticado.getCuenta()));
    }

    public void retirarEfectivo() {
        this.ejecutarOperacion(new Extraccion(this.clienteAutenticado.getCuenta()));
    }

    public void realizarDeposito() {
        this.ejecutarOperacion(new Deposito(this.clienteAutenticado.getCuenta()));
    }

    public void cambiarPin() {
        this.ejecutarOperacion(new CambiarPIN(this.clienteAutenticado.getCuenta()));
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