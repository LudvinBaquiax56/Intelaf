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
public class Producto {

    private String nombre;
    private String fabricante;
    private String codigo;
    private String cantidad;
    private String precio;
    private String descipccion;
    private String garantia;
    private String tienda;

    /**
     * Crea un objeto de tipo Producto
     *
     * @param nombre
     * @param fabricante
     * @param codigo
     * @param cantidad
     * @param precio
     */
    public Producto(String nombre, String fabricante, String codigo, String cantidad, String precio, String tienda) {
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.tienda = tienda;
    }

    /**
     * Crea un objeto de tipo Producto
     *
     * @param nombre
     * @param fabricante
     * @param codigo
     * @param cantidad
     * @param precio
     * @param descipccion
     * @param garantia
     */
    public Producto(String nombre, String fabricante, String codigo, String cantidad, String precio, String descipccion, String garantia) {
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descipccion = descipccion;
        this.garantia = garantia;
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
     * @return the fabricante
     */
    public String getFabricante() {
        return fabricante;
    }

    /**
     * @param fabricante the fabricante to set
     */
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return Integer.valueOf(cantidad);
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = String.valueOf(cantidad);
    }

    /**
     * @return the precio
     */
    public Double getPrecio() {
        return Double.valueOf(precio);
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(int precio) {
        this.precio = String.valueOf(precio);
    }

    /**
     * @return the descipccion
     */
    public String getDescipccion() {
        return descipccion;
    }

    /**
     * @param descipccion the descipccion to set
     */
    public void setDescipccion(String descipccion) {
        this.descipccion = descipccion;
    }

    /**
     * La garantia esta en meses
     *
     * @return the garantia
     */
    public int getGarantia() {
        return Integer.valueOf(garantia);
    }

    /**
     * La garantia esta en meses
     *
     * @param garantia the garantia to set
     */
    public void setGarantia(int garantia) {
        this.garantia = String.valueOf(garantia);
    }

    /**
     * @return the tienda
     */
    public String getTienda() {
        return tienda;
    }

    /**
     * @param tienda the tienda to set
     */
    public void setTienda(String tienda) {
        this.tienda = tienda;
    }

}
