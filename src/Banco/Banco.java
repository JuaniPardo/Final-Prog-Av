package Banco;

import Banco.clientes.Cliente;

import java.util.*;

/**
 * 
 */
public class Banco {
    private String nombre;
    private String razonSocial;
    private String CUIT;
    private ArrayList<Cliente> clientes;


    /**
     * @param nombre
     * @param razonSocial
     * @param CUIT
     */
    public Banco(String nombre, String razonSocial, String CUIT) {
        setNombre(nombre);
        setRazonSocial(razonSocial);
        setCUIT(CUIT);
        setClientes();
    }

    //Setters y Getters
    public String getNombre() {
        return nombre;
    }
    public String getRazonSocial() {
        return razonSocial;
    }
    public String getCUIT() {
        return CUIT;
    }
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
    public void setCUIT(String CUIT) {
        this.CUIT = CUIT;
    }
    public void setClientes() {
        new ArrayList<Cliente>();
    }

    //Metodos

    /**
     * @param nombre
     * @param apellido
     * @param CUIT
     */
    public void agregarCliente(String nombre, String apellido, String CUIT) {
        Cliente cliente = new Cliente(nombre, apellido, CUIT);
    }

    public String obtenerClientes() {
        StringBuilder sb = new StringBuilder();
        for (Cliente cliente : clientes) {
            sb.append(cliente.getNombreCompleto() + "\n");
        }
        return sb.toString();
    }

    public int obtenerNroClientes() {
        return clientes.size();
    }

    @Override
    public String toString() {
        return  "Banco: " + getNombre() + "\n" +
                "Razon Social: " + getRazonSocial() + "\n" +
                "CUIT: " + getCUIT();
    }

}