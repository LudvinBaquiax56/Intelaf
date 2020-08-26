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
public class Empleado {

    private String codigoEmpleado;
    private String nombre;
    private String telefono;
    private String nit;
    private String dpi;
    private String correoElectronico;
    private String direccion;

    /**
     * Crea un objeto de tipo Empleado
     *
     * @param codigoEmpleado
     * @param nombre
     * @param telefono
     * @param nit
     * @param dpi
     * @param correoElectronico
     * @param direccion
     */
    public Empleado(String codigoEmpleado, String nombre, String telefono, String nit, String dpi, String correoElectronico, String direccion) {
        this.codigoEmpleado = codigoEmpleado;
        this.nombre = nombre;
        this.telefono = telefono;
        this.nit = nit;
        this.dpi = dpi;
        this.correoElectronico = correoElectronico;
        this.direccion = direccion;
    }

    /**
     * Crea un objeto de tipo Empleado
     *
     * @param codigoEmpleado
     * @param nombre
     * @param telefono
     * @param dpi
     */
    public Empleado(String codigoEmpleado, String nombre, String telefono, String dpi) {
        this.codigoEmpleado = codigoEmpleado;
        this.nombre = nombre;
        this.telefono = telefono;
        this.dpi = dpi;
    }

    /**
     * Crea un objeto de tipo Empleado
     *
     * @param codigoEmpleado
     */
    public Empleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    /**
     * @return the codigoEmpleado
     */
    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    /**
     * @param codigoEmpleado the codigoEmpleado to set
     */
    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
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
