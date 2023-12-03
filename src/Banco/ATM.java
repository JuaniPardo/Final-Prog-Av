package Banco;

import Banco.Operaciones.Operacion;

import java.util.Scanner;

/**
 * 
 */
public class ATM {


    public static final ATM instancia = new ATM();
    private Cliente clienteAutenticado;
    private Entrada entrada;
    private Salida salida;

    //Constructor Singleton
    private ATM() {
        setEntrada();
        setSalida();
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
    public void setEntrada() {
        this.entrada = new Teclado();
    }
    public Salida getSalida() {
        return salida;
    }
    public void setSalida() {
        this.salida = new Pantalla();
    }

    public void ejecutarOperacion(Operacion operacion) {
        operacion.ejecutar();
    }

    public void mostrarMenu() {
        // TODO implement here
    }

    @Override
    public String toString() {
        return "ATM{" +
                "clienteAutenticado=" + clienteAutenticado +
                ", entrada=" + entrada +
                ", salida=" + salida +
                '}';
    }
}