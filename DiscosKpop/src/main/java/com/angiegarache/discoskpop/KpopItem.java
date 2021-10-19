/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.angiegarache.discoskpop;

/**
 *
 * @author Angie Garache
 */

import java.util.ArrayList;
import java.util.Date;




public class KpopItem {
    /**
     * @return the _cedula
     */
    public String getnumeroalbum() {
        return _numeroalbum;
    }

    /**
     * @param _numeroalbum the _cedula to set
     */
    public void setnumeroalbum(String _numeroalbum) {
        this._numeroalbum = _numeroalbum;
    }
     /**
     * @return the _id
     */
    public int getId() {
        return _id;
    }

    /**
     * @param _id the _id to set
     */
    public void setId(int _id) {
        this._id = _id;
    }

    /**
     * @return the _nombre
     */
    public String getNombrealbum() {
        return _nombrealbum;
    }

    /**
     * @param _nombre the _nombre to set
     */
    public void setNombre(String _nombre) {
        this._nombrealbum = _nombre;
    }

    /**
     * @return the _precio
     */
    public String getPrecio() {
        return _precio;
    }

    /**
     * @param _precio the _precio to set
     */
    public void setPrecio(String _precio) {
        this._precio = _precio;
    }

    /**
     * @return the _fechaentrada
     */
    public Date getFechaentrada() {
        return _fechaentrada;
    }

    /**
     * @param _fechaentrada the _fechaentrada to set
     */
    public void setFechaentrada(Date _fechaentrada) {
        this._fechaentrada = _fechaentrada;
    }

    
    /**
     * @return the _id
     */
  
    private int _id;
    private String _numeroalbum;
    private String _nombrealbum;
    private String  _precio;
    private Date _fechaentrada;
    
    public KpopItem(){
        this._id = 0;
        this._numeroalbum = "";
        this._nombrealbum = "";
        this._precio = "";
        this._fechaentrada =  new Date();
    }
    
    public KpopItem(int id, String nombre, String precio,String cedula, String duracion, Date fechaentrada) {
        this._id = id;
        this._numeroalbum = "";
        this._nombrealbum = nombre;
        this._precio = "";
       
        this._fechaentrada =  new Date();
    }

    public ArrayList<String> obtenerCampos(){
        ArrayList<String> campos = new ArrayList<String>();
        campos.add(String.valueOf(this.getId()));
        campos.add(this.getnumeroalbum());
        campos.add(this.getNombrealbum());
        campos.add(this.getPrecio());
        campos.add("____");

        return campos;

    }
}
