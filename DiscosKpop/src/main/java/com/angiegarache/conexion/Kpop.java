/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.angiegarache.conexion;

/**
 *
 * @author Angie Garache
 */

import com.angiegarache.discoskpop.KpopItem;
import java.util.ArrayList;
import java.util.ArrayList;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Kpop {
    private ArrayList _cursoItems;
    private ArrayList<KpopItem> _KpopItems;
    
    public Kpop(){
            this._cursoItems = new ArrayList<KpopItem>();
    }
    
    public ArrayList<KpopItem> getCursoItems(){
        return this.getKpopItems(false);
    }
    
    public void tableInitialize(){
        String sqlCreate = "CREATE TABLE IF NOT EXISTS CURSO"
                        + " (ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                        + " NUMERO DE ALBUM TEXT NOT NULL,"
                        + " NOMBRE DEL ALBUM TEXT NOT NULL,"
                        + " PRECIO TEXT NOT NULL,"
                 
                        + ")";
       
        try {
            Statement comando = Conexion.getConexion().createStatement();
            int resultado = comando.executeUpdate(sqlCreate);
            comando.close();
        } catch( Exception ex){
            System.err.println(ex.getMessage());
        }
    }
    
    public ArrayList<KpopItem> getKpopItems(boolean forceLoad){
        try {
           if (forceLoad) {
                Statement comando =  Conexion.getConexion().createStatement();
                ResultSet misRegistro = comando.executeQuery("SELECT * from ALBUM;");
                this._KpopItems.clear();
                while (misRegistro.next()) {
                    KpopItem registro = new KpopItem();
                    registro.setId(misRegistro.getInt("ID"));
                    registro.setPrecio(misRegistro.getString("NUMERO DE ALBUM"));
                    registro.setNombre(misRegistro.getString("NOMBRE DEL ALBUM"));
                    registro.setPrecio(misRegistro.getString("PRECIO"));
                    this._KpopItems.add(registro);
                }
                comando.close();
           }
           return this._KpopItems;
        } catch(Exception ex){
            System.err.println(ex.getMessage());
            return this._KpopItems;
        }   
    }
    
    public KpopItem getCursoItemById(int id){
        try {
            String SQLGetByID = "SELECT * FROM KPOP WHERE ID = ?;";
            PreparedStatement comando =  Conexion.getConexion().prepareStatement(SQLGetByID);
            comando.setInt(1, id);
            ResultSet misRegistro = comando.executeQuery();
            KpopItem registro = new KpopItem();
            while (misRegistro.next()) {
                registro.setId(misRegistro.getInt("ID"));
                 registro.setPrecio(misRegistro.getString("Numero de Album"));
                registro.setNombre(misRegistro.getString("Nombre del album"));
                registro.setPrecio(misRegistro.getString("PRECIO"));
                
                break;
            }
            comando.close();

            return registro;
        } catch(Exception ex){
            System.err.println(ex.getMessage());
            return null;
        }   
    }
    
    public int updateCursoItem(KpopItem ItemToUpdate) {
        try {
            String SQLUpdate = "UPDATE ALBUM set NUMERO DE ALBUM=?,NUMERO DE ALBUM=?, PRECIO=? where ID=?;";
            PreparedStatement comando = Conexion.getConexion().prepareStatement(SQLUpdate);
            
            comando.setString(1, ItemToUpdate.getNombrealbum());
            comando.setString(3, ItemToUpdate.getPrecio());
            comando.setString(4, ItemToUpdate.getnumeroalbum());
            comando.setInt(5, ItemToUpdate.getId());
            
            int registrAfectado = comando.executeUpdate();
            comando.close();
            return registrAfectado;
            
        } catch( Exception ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }
     public int insertKpopItem(KpopItem ItemToInsert) {
        try {
            String SQLInsert = "INSERT INTO ALBUM (NOMBRE DEL ALBUM,NUMERO DE ALBUM, PRECIO) values (?, ?, ?);";
            PreparedStatement comando = Conexion.getConexion().prepareStatement(SQLInsert);
            
            comando.setString(1, ItemToInsert.getNombrealbum());
            comando.setString(2, ItemToInsert.getnumeroalbum());
            comando.setString(3, ItemToInsert.getPrecio());
           
            
            int registrAfectado = comando.executeUpdate();
            comando.close();
            return registrAfectado;
            
        } catch( Exception ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }
     
    public int deleteCursoItem(KpopItem ItemToDelete) {
        try {
            String SQLDelete = "DELETE FROM ALBUM WHERE ID = ?;";
            PreparedStatement comando = Conexion.getConexion().prepareStatement(SQLDelete);
            
            comando.setInt(1, ItemToDelete.getId());
            
            int registrAfectado = comando.executeUpdate();
            comando.close();
            return registrAfectado;
            
        } catch( Exception ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }
}
