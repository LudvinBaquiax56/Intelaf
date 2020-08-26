/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Clases.Cliente;
import Clases.Empleado;
import Clases.Pedido;
import Clases.Producto;
import Clases.Sistema;
import Clases.TiempoEntreTiendas;
import Clases.Tienda;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author baquiax
 */
public class ControladorSistema {

    private final Sistema sistema;

    public ControladorSistema(Sistema sistema) {
        this.sistema = sistema;
        cargarEmpleados();
        cargarClientes();
    }

    /**
     * Cargar datos
     *
     * @param ruta
     * @param sistema
     */
    public void cargarDatos(String ruta, Sistema sistema) {
        try (FileReader entrada = new FileReader(ruta)) {
            BufferedReader miBuffer = new BufferedReader(entrada);
            String linea = "";
            String datos = "";
            while (linea != null) {

                linea = miBuffer.readLine();
                if (linea != null) {
                    datos = datos + linea + "\n";
                }
            }
            String[] aux = datos.split("\n");
            for (String datoIngresar : aux) {
                String datosEspecificos[] = datoIngresar.split(",");
                switch (datosEspecificos[0]) {
                    case "TIENDA":
                        agregarTienda(datosEspecificos, sistema);
                        break;
                    case "TIEMPO":
                        agregarTiempoEntreTienda(datosEspecificos);
                        break;
                    case "PRODUCTO":
                        agregarProducto(datosEspecificos);
                        break;
                    case "CLIENTE":
                        agregarCliente(datosEspecificos);
                        break;
                    case "EMPLEADO":
                        agregarEmpleado(datosEspecificos);
                        break;
                    case "PEDIDO":
                        agregarPedido(datosEspecificos);
                        break;
                    default:
                        break;
                }
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {

        }
    }

    /**
     * Agrega una tienda
     *
     * @param datosEspecificos
     */
    private void agregarTienda(String[] datosEspecificos, Sistema sistema) {
        Tienda tienda = new Tienda(datosEspecificos[1], datosEspecificos[2], datosEspecificos[3], datosEspecificos[4]);

        String query = "INSERT INTO Tienda (Codigo,Nombre,Direccion,Telefono) VALUES (?,?,?,?)";
        String codigo = tienda.getCodigo();
        String nombre = tienda.getNombre();
        String direccion = tienda.getDireccion();
        String telefono = tienda.getTelefono();

        try (PreparedStatement preSt = sistema.getConexion().prepareStatement(query)) {
            preSt.setString(1, codigo);
            preSt.setString(2, nombre);
            preSt.setString(3, direccion);
            preSt.setString(4, telefono);
            preSt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en los datos tienda\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Agrega una tiempo entre tienda
     *
     * @param datosEspecificos
     */
    private void agregarTiempoEntreTienda(String[] datosEspecificos) {
        TiempoEntreTiendas tiempoEntreTiendas = new TiempoEntreTiendas(datosEspecificos[1], datosEspecificos[2], datosEspecificos[3]);
        String query = "INSERT INTO Tiempo_Entre_Tiendas (Dias,Tienda_Codigo,Tienda_Codigo1) VALUES (?,?,?)";

        String tienda1 = tiempoEntreTiendas.getTienda1();
        String tienda2 = tiempoEntreTiendas.getTienda2();
        String tiempo = tiempoEntreTiendas.getTiempo();
        try (PreparedStatement preSt = sistema.getConexion().prepareStatement(query)) {
            preSt.setString(1, tiempo);
            preSt.setString(2, tienda1);
            preSt.setString(3, tienda2);
            preSt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en los datos del tiempo entre tienda\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Agrega un Producto
     *
     * @param datosEspecificos
     */
    private void agregarProducto(String[] datosEspecificos) {
        Producto producto = new Producto(datosEspecificos[1], datosEspecificos[2], datosEspecificos[3], datosEspecificos[4], datosEspecificos[5], datosEspecificos[6]);
        String codigo = producto.getCodigo();
        String nombre = producto.getNombre();
        String fabricante = producto.getFabricante();
        String precio = String.valueOf(producto.getPrecio());

        String query = "INSERT INTO Producto (Codigo,Nombre,Fabricante,Precio) VALUES (?,?,?,?)";
        try (PreparedStatement preSt = sistema.getConexion().prepareStatement(query)) {
            preSt.setString(1, codigo);
            preSt.setString(2, nombre);
            preSt.setString(3, fabricante);
            preSt.setString(4, precio);
            preSt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en los datos del Producto o Actualizacion del producto\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        String tienda = producto.getTienda();
        String cantidad = String.valueOf(producto.getCantidad());
        String query2 = "INSERT INTO Detalle_Producto_En_Tienda (Producto_Codigo,Tienda_Codigo,Cantidad) VALUES (?,?,?)";
        try (PreparedStatement preSt = sistema.getConexion().prepareStatement(query2)) {
            preSt.setString(1, codigo);
            preSt.setString(2, tienda);
            preSt.setString(3, cantidad);
            preSt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en los datos del Producto\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Agrega un Cliente
     *
     * @param datosEspecificos
     */
    private void agregarCliente(String[] datosEspecificos) {
        Cliente cliente = new Cliente(datosEspecificos[1], datosEspecificos[2], datosEspecificos[3], datosEspecificos[4]);
        String nit = cliente.getNit();
        String nombre = cliente.getNombre();
        String telefono = cliente.getTelefono();
        String creditoCompra = cliente.getCreditoDeCompra();
        String query = "INSERT INTO Cliente (NIT,Nombre,Telefono,Credito_De_Compra) VALUES (?,?,?,?)";
        try (PreparedStatement preSt = sistema.getConexion().prepareStatement(query)) {
            preSt.setString(1, nit);
            preSt.setString(2, nombre);
            preSt.setString(3, telefono);
            preSt.setString(4, creditoCompra);
            preSt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en los datos del Cliente\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Agrega un Empleado
     *
     * @param datosEspecificos
     */
    private void agregarEmpleado(String[] datosEspecificos) {
        Empleado empleado = new Empleado(datosEspecificos[1], datosEspecificos[2], datosEspecificos[3], datosEspecificos[4]);
        String codigo = empleado.getCodigoEmpleado();
        String nombre = empleado.getNombre();
        String telefono = empleado.getTelefono();
        String dpi = empleado.getDpi();
        String query = "INSERT INTO Empleado (Codigo,Nombre,Telefono,DPI) VALUES (?,?,?,?)";
        try (PreparedStatement preSt = sistema.getConexion().prepareStatement(query)) {
            preSt.setString(1, codigo);
            preSt.setString(2, nombre);
            preSt.setString(3, telefono);
            preSt.setString(4, dpi);
            preSt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en los datos del Empleado\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void agregarPedido(String[] datosEspecificos) {
        Pedido pedido = new Pedido(datosEspecificos[1], datosEspecificos[2], datosEspecificos[3],
                datosEspecificos[4], datosEspecificos[5], datosEspecificos[6], datosEspecificos[7], datosEspecificos[8],
                datosEspecificos[9]);
        String codigo = pedido.getCodigo();
        String tienda1 = pedido.getTienda1();
        String tienda2 = pedido.getTienda2();
        String fecha = pedido.getFechaRealizadoPedido();
        String cliente = pedido.getCliente();
        String total = pedido.getTotal();
        String anticipo = pedido.getAnticipo();

        String query = "INSERT INTO Pedido (Codigo,Tienda_Origen,Tienda_Destino,Fecha,Cliente_NIT,Total,Anticipo) VALUES (?,?,?,?,?,?,?)";
        try (PreparedStatement preSt = sistema.getConexion().prepareStatement(query)) {
            preSt.setString(1, codigo);
            preSt.setString(2, tienda1);
            preSt.setString(3, tienda2);
            preSt.setString(4, fecha);
            preSt.setString(5, cliente);
            preSt.setString(6, total);
            preSt.setString(7, anticipo);
            preSt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "El pedido ya se registro y agregando datos correspondientes\n"
                    + " O error en los datos del Pedido\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        String articulo = pedido.getArticulo();
        String cantidad = pedido.getCantidad();
        String query2 = "INSERT INTO Detalle_Pedido (Producto_Codigo,Pedido_Codigo,Cantidad) VALUES (?,?,?)";
        try (PreparedStatement preSt = sistema.getConexion().prepareStatement(query2)) {
            preSt.setString(1, articulo);
            preSt.setString(2, codigo);
            preSt.setString(3, cantidad);
            preSt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el producto o en el pedido\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Carga los Empleados existentes en la base de datos al sistema
     */
    private void cargarEmpleados() {
        String query = "SELECT Codigo FROM Empleado";
        try (PreparedStatement preSt = sistema.getConexion().prepareStatement(query)) {
            ResultSet result = preSt.executeQuery();

            while (result.next()) {
                sistema.getEmpleados().add(new Empleado(result.getString(1)));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Carga los clientes existentes en la base de datos al sistema
     */
    private void cargarClientes() {
        String query = "SELECT NIT FROM Cliente";
        try (PreparedStatement preSt = sistema.getConexion().prepareStatement(query)) {
            ResultSet result = preSt.executeQuery();

            while (result.next()) {
                sistema.getClientes().add(new Cliente(result.getString(1)));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
