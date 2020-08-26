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
public class Pedido {

    private String codigo;
    private String tienda1;
    private String tienda2;
    private String fechaRealizadoPedido;
    private String cliente;
    private String articulo;
    private String cantidad;
    private String total;
    private String anticipo;

    /**
     * Crea un objeto de tipo Pedido
     *
     * @param codigo
     * @param tienda1
     * @param tienda2
     * @param fechaRealizadoPedido
     * @param cliente
     * @param articulo
     * @param cantidad
     * @param total
     * @param anticipo
     */
    public Pedido(String codigo, String tienda1, String tienda2, String fechaRealizadoPedido, String cliente, String articulo, String cantidad, String total, String anticipo) {
        this.codigo = codigo;
        this.tienda1 = tienda1;
        this.tienda2 = tienda2;
        this.fechaRealizadoPedido = fechaRealizadoPedido;
        this.cliente = cliente;
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.total = total;
        this.anticipo = anticipo;
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
     * @return the tienda1
     */
    public String getTienda1() {
        return tienda1;
    }

    /**
     * @param tienda1 the tienda1 to set
     */
    public void setTienda1(String tienda1) {
        this.tienda1 = tienda1;
    }

    /**
     * @return the tienda2
     */
    public String getTienda2() {
        return tienda2;
    }

    /**
     * @param tienda2 the tienda2 to set
     */
    public void setTienda2(String tienda2) {
        this.tienda2 = tienda2;
    }

    /**
     * @return the cliente
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the articulo
     */
    public String getArticulo() {
        return articulo;
    }

    /**
     * @param articulo the articulo to set
     */
    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    /**
     * @return the cantidad
     */
    public String getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the total
     */
    public String getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(String total) {
        this.total = total;
    }

    /**
     * @return the anticipo
     */
    public String getAnticipo() {
        return anticipo;
    }

    /**
     * @param anticipo the anticipo to set
     */
    public void setAnticipo(String anticipo) {
        this.anticipo = anticipo;
    }

    /**
     * @return the fechaRealizadoPedido
     */
    public String getFechaRealizadoPedido() {
        return fechaRealizadoPedido;
    }

    /**
     * @param fechaRealizadoPedido the fechaRealizadoPedido to set
     */
    public void setFechaRealizadoPedido(String fechaRealizadoPedido) {
        this.fechaRealizadoPedido = fechaRealizadoPedido;
    }

}
