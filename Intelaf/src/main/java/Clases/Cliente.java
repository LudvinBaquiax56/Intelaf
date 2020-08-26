/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author baquiax
 */
public class Cliente {

    private String nombre;
    private String telefono;
    private String nit;
    private String dpi;
    private String creditoDeCompra;
    private String correoElectronico;
    private String direccion;

    /**
     * Crea un objeto de tipo Cliente
     *
     * @param nombre
     * @param nit
     * @param telefono
     * @param creditoDeCompra
     */
    public Cliente(String nombre, String nit, String telefono, String creditoDeCompra) {
        this.nombre = nombre;
        this.nit = nit;
        this.telefono = telefono;
        this.creditoDeCompra = creditoDeCompra;
    }

    /**
     * Crea un objeto de tipo Cliente
     *
     * @param nombre
     * @param telefono
     * @param nit
     * @param dpi
     * @param creditoDeCompra
     * @param correoElectronico
     * @param direccion
     */
    public Cliente(String nombre, String telefono, String nit, String dpi, String creditoDeCompra, String correoElectronico, String direccion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.nit = nit;
        this.dpi = dpi;
        this.creditoDeCompra = creditoDeCompra;
        this.correoElectronico = correoElectronico;
        this.direccion = direccion;
    }

    /**
     * Crea un objeto de tipo Cliente
     *
     * @param nit
     */
    public Cliente(String nit) {
        this.nit = nit;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the nit
     */
    public String getNit() {
        return nit;
    }

    /**
     * @param nit the nit to set
     */
    public void setNit(String nit) {
        this.nit = nit;
    }

    /**
     * @return the dpi
     */
    public String getDpi() {
        return dpi;
    }

    /**
     * @param dpi the dpi to set
     */
    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    /**
     * @return the creditoDeCompra
     */
    public String getCreditoDeCompra() {
        return creditoDeCompra;
    }

    /**
     * @param creditoDeCompra the creditoDeCompra to set
     */
    public void setCreditoDeCompra(String creditoDeCompra) {
        this.creditoDeCompra = creditoDeCompra;
    }

    /**
     * @return the correoElectronico
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * @param correoElectronico the correoElectronico to set
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
