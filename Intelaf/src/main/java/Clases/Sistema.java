/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author baquiax
 */
public class Sistema {

    private List<Cliente> clientes;
    private List<Empleado> empleados;
    private List<Pedido> pedidos;
    private List<Producto> productos;
    private List<TiempoEntreTiendas> tiempoEntreTiendas;
    private List<Tienda> tiendas;
    private Calendar fechaSistema;
    private Connection conexion;

    public Sistema() {
        clientes = new ArrayList<>();
        empleados = new ArrayList<>();
        pedidos = new ArrayList<>();
        productos = new ArrayList<>();
        tiendas = new ArrayList<>();
        fechaSistema = Calendar.getInstance();
        String url = "jdbc:mysql://localhost:3306/Intelaf?useSSL=false";
        String user = "root";
        String password = "admin1234";
        try {
            this.conexion = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    /**
     * @return the clientes
     */
    public List<Cliente> getClientes() {
        return clientes;
    }

    /**
     * @param clientes the clientes to set
     */
    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    /**
     * @return the empleados
     */
    public List<Empleado> getEmpleados() {
        return empleados;
    }

    /**
     * @param empleados the empleados to set
     */
    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    /**
     * @return the pedidos
     */
    public List<Pedido> getPedidos() {
        return pedidos;
    }

    /**
     * @param pedidos the pedidos to set
     */
    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    /**
     * @return the productos
     */
    public List<Producto> getProductos() {
        return productos;
    }

    /**
     * @param productos the productos to set
     */
    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    /**
     * @return the tiempoEntreTiendas
     */
    public List<TiempoEntreTiendas> getTiempoEntreTiendas() {
        return tiempoEntreTiendas;
    }

    /**
     * @param tiempoEntreTiendas the tiempoEntreTiendas to set
     */
    public void setTiempoEntreTiendas(List<TiempoEntreTiendas> tiempoEntreTiendas) {
        this.tiempoEntreTiendas = tiempoEntreTiendas;
    }

    /**
     * @return the tiendas
     */
    public List<Tienda> getTiendas() {
        return tiendas;
    }

    /**
     * @param tiendas the tiendas to set
     */
    public void setTiendas(List<Tienda> tiendas) {
        this.tiendas = tiendas;
    }

    /**
     * @return the fechaSistema
     */
    public Calendar getFechaSistema() {
        return fechaSistema;
    }

    /**
     * @param fechaSistema the fechaSistema to set
     */
    public void setFechaSistema(Calendar fechaSistema) {
        this.fechaSistema = fechaSistema;
    }

    /**
     * @return the conexion
     */
    public Connection getConexion() {
        return conexion;
    }

    /**
     * @param conexion the conexion to set
     */
    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

}
