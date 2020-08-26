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
public class TiempoEntreTiendas {

    private String tienda1;
    private String tienda2;
    private String tiempo;

    /**
     * Crea una objeto, para el tiempo entre teindas
     *
     * @param tienda1
     * @param tienda2
     * @param tiempo
     */
    public TiempoEntreTiendas(String tienda1, String tienda2, String tiempo) {
        this.tienda1 = tienda1;
        this.tienda2 = tienda2;
        this.tiempo = tiempo;
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
     * @return the tiempo
     */
    public String getTiempo() {
        return tiempo;
    }

    /**
     * @param tiempo the tiempo to set
     */
    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

}
